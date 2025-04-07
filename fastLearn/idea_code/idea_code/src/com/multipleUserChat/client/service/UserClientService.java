package com.multipleUserChat.client.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;
import com.multipleUserChat.common.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Vector;

/**
 * 完成用户登录注册功能
 */
public class UserClientService {
    private boolean flag = false;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean checkUser(String userId, String password) {
        user = new User(userId, password);
        //将User对象发送给服务端
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src\\com\\multipleUserChat\\client\\configuration.properties"));
            Socket socket = new Socket(InetAddress.getByName(properties.getProperty("serverIp")), Integer.parseInt(properties.getProperty("serverPort")));
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);//发送User到服务端
            oos.flush();
//            socket.shutdownOutput();
            //接收服务端发送的信息，并返回是否成功注册
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();
            //登录判断
            if (message.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                //成功登录创建一个与服务端通信的线程
                ClientConnectServerThread thread = new ClientConnectServerThread(socket);
                thread.start();//开启线程
                //将线程加入到集合管理
                ManageClientConnectServerThread.add(userId, thread);
                flag = true;
                if (message.getLeftMessage() != null) {
                    //判断是否有留言
                    Vector<Message> leftMessage = message.getLeftMessage();
                    for (Message message1 :leftMessage) {
                        if(message1.getMsgType().equals(MessageType.MESSAGE_COMMON_MESSAGE)){
                            //普通留言 直接打印
                            System.out.println("\n" + message1.getSender() + " 对" + message1.getReceiver() + " 说：" + message1.getContent());
                        }else if (message1.getMsgType().equals(MessageType.MESSAGE_FILE_MESSAGE)){
                            //文件直接下载
                            System.out.println("\n" + message1.getSender() + " 向 " + message1.getReceiver() + " 发送了一个文件到" + message1.getDestFilePath());
                            FileOutputStream fos = new FileOutputStream(new File(message1.getDestFilePath()));
                            fos.write(message1.getFileBytes());
                            fos.close();
                        }else{
                            System.out.println("\n暂未处理的类型~~");
                        }
                    }

                }
            } else {
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }

    public void onlineFriendList() {
        //发送用户列表请求
        Message message = new Message();
        message.setSender(user.getUsrId());
        message.setMsgType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        //向客户端发送请求
        sendMessage(message);
    }

    public void userExit() {
        //用户退出
        Message message = new Message();
        message.setSender(user.getUsrId());
        message.setMsgType(MessageType.MESSAGE_CLIENT_EXIT);
        sendMessage(message);
        System.out.println("========(" + user.getUsrId() + ")正在退出=======");
        System.exit(0);
    }

    public void sendMessage(Message message) {
        ClientConnectServerThread thread = ManageClientConnectServerThread.get(user.getUsrId());
        Socket socket = thread.getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
