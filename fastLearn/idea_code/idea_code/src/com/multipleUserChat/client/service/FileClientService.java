package com.multipleUserChat.client.service;

import com.multipleUserChat.common.Message;
import com.multipleUserChat.common.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * 该类用于文件传输
 */
public class FileClientService {
    public void sendFileToOne(String senderId, String receiverId, String srcFilePath, String destFilePath) {
        Message message = new Message();
        message.setSendTime(new Date().toString());
        message.setMsgType(MessageType.MESSAGE_FILE_MESSAGE);
        message.setSender(senderId);
        message.setReceiver(receiverId);
        message.setDestFilePath(destFilePath);
        message.setSrcFilePath(srcFilePath);

        //读入文件
        FileInputStream fis = null;
        byte[] fileBytes = new byte[(int) new File(srcFilePath).length()];
        try {
            fis = new FileInputStream(new File(srcFilePath));
            fis.read(fileBytes);
            message.setFileBytes(fileBytes);
            message.setLen(fileBytes.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //将message发送给服务端
        MessageClientService.sendMessage(senderId, message);
        System.out.println("\n"+message.getSender()+" 正在向 "+message.getReceiver()+" 发送文件~~");
    }
}
