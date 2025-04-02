package com.multipleUserChat.client.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * 群聊私聊等消息业务属于这里
 */
public class MessageClientService {
    public void sendMessageToOne(String senderId, String receiverId, String content){
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_COMMON_MESSAGE);
        message.setSender(senderId);
        message.setReceiver(receiverId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        try {
            //获取发送者的socket并发送消息
            ClientConnectServerThread thread = ManageClientConnectServerThread.get(senderId);
            Socket socket = thread.getSocket();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
