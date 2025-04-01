package com.multipleUserChat.server.service;
import com.multipleUserChat.common.Message;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerConnectClientThread extends Thread {
    private String userId;
    private Socket socket;

    @Override
    public void run() {
        while (true){
            //循环接收客户端发送的消息
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message =(Message) ois.readObject();//客户端未输入就阻塞

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }
}
