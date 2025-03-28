package com.multipleUserChat.client.service;

import com.multipleUserChat.client.common.Message;
import com.multipleUserChat.client.common.MessageType;
import com.multipleUserChat.client.common.User;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

/**
 * 完成用户登录注册功能
 */
public class ClientService {
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
            } else {
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
