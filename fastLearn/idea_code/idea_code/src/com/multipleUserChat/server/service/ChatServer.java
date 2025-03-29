package com.multipleUserChat.server.service;

import com.multipleUserChat.server.common.Message;
import com.multipleUserChat.server.common.MessageType;
import com.multipleUserChat.server.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    ServerSocket serverSocket;

    public ChatServer() {
        try {
            System.out.println("正在监听9999端口");
            serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            //判断用户登录是否合法
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            User user = (User) ois.readObject();
            Message message = new Message();
            if ("100".equals(user.getUsrId()) && "1111".equals(user.getPassword())) {
                //如果合法就登录成功返回数据
                message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCEED);
                oos.writeObject(message);
                oos.flush();
                socket.shutdownOutput();
                //socket加入线程
                ServerConnectClientThread thread = new ServerConnectClientThread(user.getUsrId(), socket);
                thread.start();
                //线程加入管理
                ManageServerConnectClientThreads.add(user.getUsrId(), thread);

            } else {
                message.setMsgType(MessageType.MESSAGE_LOGIN_FAIL);
                oos.writeObject(message);
                oos.flush();
                socket.shutdownOutput();
                //关闭资源
                oos.close();
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
