package com.multipleUserChat.server.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ServerConnectClientThread extends Thread {
    private String userId;
    private Socket socket;

    @Override
    public void run() {
        while (true) {
            //循环接收客户端发送的消息
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();//客户端未输入就阻塞
                System.out.println("正在和(" + userId + ")保持通信,等待客户端发送数据");
                if (message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    System.out.println(message.getSender() + "正在获取用户列表");
                    //返回用户列表 用户id以空格隔开
                    Message message1 = new Message();
                    message1.setMsgType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    String onlineUser = ManageServerConnectClientThreads.getOnlineUser();
                    message1.setContent(onlineUser);
                    message1.setReceiver(message.getSender());
                    oos.writeObject(message1);
                } else if (message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + " 正在退出~~");
                    //退出登录 关闭对应socket 移除对应线程并关闭
                    ManageServerConnectClientThreads.removeThread(message.getSender());
                    socket.close();
                    break;
                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MESSAGE)) {
                    System.out.println(message.getSender() + " 正在向 " + message.getReceiver() + " 发送数据~~");
                    //文件转发
                    ServerConnectClientThread receiverThread = ManageServerConnectClientThreads.getThread(message.getReceiver());
                    if(receiverThread != null){
                        ObjectOutputStream oos = new ObjectOutputStream(receiverThread.socket.getOutputStream());
                        oos.writeObject(message);
                    }else {
                        //对象不在直接留言将信息存入leftMessage
                        ChatServer.addLeftMessage(message);
                        Message systemMessage = new Message();
                        systemMessage.setSender("服务器");
                        systemMessage.setReceiver(userId);
                        systemMessage.setMsgType(MessageType.MESSAGE_COMMON_MESSAGE);
                        systemMessage.setContent("收信人不在，已将消息加入留言箱，收信人上线自动接收");
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(systemMessage);
                    }
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMMON_MESSAGE_TO_ALL)) {
                    //群发消息
                    System.out.println(message.getSender() + " 正在群发消息：" + message.getContent());
                    HashMap<String, ServerConnectClientThread> hashMap = ManageServerConnectClientThreads.getHashMap();
                    for (String userId : hashMap.keySet()) {
                        if (!userId.equals(message.getSender())) {
                            ServerConnectClientThread thread = ManageServerConnectClientThreads.getThread(userId);
                            Socket userSocket = thread.getSocket();
                            ObjectOutputStream oos = new ObjectOutputStream(userSocket.getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMMON_MESSAGE)) {
                    //获取收信人的socket并转发消息
                    ServerConnectClientThread thread = ManageServerConnectClientThreads.getThread(message.getReceiver());
                    if (thread != null){
                        //私聊消息
                        System.out.println(message.getSender() + "正在和" + message.getReceiver() + "私聊");
                        //收信人的线程存在则发送
                        Socket receiverSocket = thread.getSocket();
                        try {
                            ObjectOutputStream outputStream = new ObjectOutputStream(receiverSocket.getOutputStream());
                            outputStream.writeObject(message);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        //收信人线程不存在则在留言中添加
                        ChatServer.addLeftMessage(message);
                        Message systemMessage = new Message();
                        systemMessage.setSender("服务器");
                        systemMessage.setReceiver(userId);
                        systemMessage.setMsgType(MessageType.MESSAGE_COMMON_MESSAGE);
                        systemMessage.setContent("收信人不在，已将消息加入留言箱，收信人上线自动接收");
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(systemMessage);
                    }

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }
}
