package com.multipleUserChat.client.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Vector;

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
                if (message.getMsgType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    String[] data = message.getContent().split(" ");
                    System.out.println("\n==========当前在线用户列表=========");
                    for (String datum : data) {
                        //输出用户列表
                        System.out.println("用户：" + datum);
                    }
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMMON_MESSAGE)) {
                    System.out.println("\n" + message.getSender() + " 对" + message.getReceiver() + " 说：" + message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMMON_MESSAGE_TO_ALL)) {
                    System.out.println(message.getSender() + " 对大家说：" + message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MESSAGE)) {
                    System.out.println("\n" + message.getSender() + " 向 " + message.getReceiver() + " 发送了一个文件到" + message.getDestFilePath());
                    FileOutputStream fos = new FileOutputStream(new File(message.getDestFilePath()));
                    fos.write(message.getFileBytes());
                    fos.close();
                } else if (message.getMsgType().equals(MessageType.MESSAGE_LEFT_MESSAGE)) {
                    //留言消息/文件处理逻辑
                    System.out.println("\n正在接受留言消息/文件");
                    Vector<Message> leftMessage = message.getLeftMessage();
                    for (Message m : leftMessage) {
                        if (m.getMsgType().equals(MessageType.MESSAGE_COMMON_MESSAGE)){
                            //接收的私聊留言
                            System.out.println("\n" + message.getSender() + " 对" + message.getReceiver() + " 说：" + message.getContent());
                        } else if (m.getMsgType().equals(MessageType.MESSAGE_FILE_MESSAGE)) {
                            System.out.println("\n" + message.getSender() + " 向 " + message.getReceiver() + " 发送了一个文件到" + message.getDestFilePath());
                            FileOutputStream fos = new FileOutputStream(new File(message.getDestFilePath()));
                            fos.write(message.getFileBytes());
                            fos.close();
                        } else if (m.getMsgType().equals(MessageType.MESSAGE_COMMON_MESSAGE_TO_ALL)) {
                            System.out.println(message.getSender() + " 对大家说：" + message.getContent());
                        }else {
                            System.out.println("暂未处理类型的留言/消息~~");
                        }
                    }
                } else {
                    System.out.println("其他暂未处理~~~");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
