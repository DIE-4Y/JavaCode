package com.multipleUserChat.server.service;
import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                System.out.println("正在和("+userId+")保持通信,等待客户端发送数据");
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                if (message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    System.out.println(message.getSender()+"正在获取用户列表");
                    //返回用户列表 用户id以空格隔开
                    Message message1 = new Message();
                    message1.setMsgType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    String onlineUser = ManageServerConnectClientThreads.getOnlineUser();
                    message1.setContent(onlineUser);
                    message1.setReceiver(message.getSender());
                    oos.writeObject(message1);
                }else if (message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender()+" 正在退出~~");
                    //关闭对应socket 移除对应线程并关闭
                    ManageServerConnectClientThreads.removeThread(message.getSender());
                    socket.close();
                    break;
                }
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
