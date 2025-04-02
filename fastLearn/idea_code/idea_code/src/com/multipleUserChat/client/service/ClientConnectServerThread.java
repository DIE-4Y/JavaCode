package com.multipleUserChat.client.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            //一直接收数据
            try {
                System.out.println("\n正在等待服务端发送数据");
                //如果服务端没发送数据就会一直等待
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //根据消息类型对获取的信息进行处理
                //1.用户列表数据返回
                if(message.getMsgType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    String[] data = message.getContent().split(" ");
                    System.out.println("\n==========当前在线用户列表=========");
                    for (String datum : data) {
                        //输出用户列表
                        System.out.println("用户："+datum);
                    }
                }else {
                    System.out.println("其他暂未处理~~~");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
