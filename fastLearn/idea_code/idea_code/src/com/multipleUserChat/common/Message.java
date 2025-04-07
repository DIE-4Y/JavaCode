package com.multipleUserChat.common;

import com.sun.xml.internal.ws.api.model.MEP;

import java.io.Serializable;
import java.io.StringReader;
import java.util.Vector;

/**
 * 通信时的消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sender;//发送者
    private String receiver;//接收者
    private String content;
    private String sendTime;
    private String msgType;//消息类型
    private byte[] fileBytes;
    private int len = 0;
    private String srcFilePath;
    private String destFilePath;
    private Vector<Message> leftMessage = new Vector<>();//留言

    public void removeLeftMessage(Message message) {
        leftMessage.remove(message);
    }

    public void addLeftMessage(Message message) {
        leftMessage.add(message);
    }

    public Vector<Message> getLeftMessage() {
        return leftMessage;
    }

    public void setLeftMessage(Vector<Message> leftMessage) {
        this.leftMessage = leftMessage;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getSrcFilePath() {
        return srcFilePath;
    }

    public void setSrcFilePath(String srcFilePath) {
        this.srcFilePath = srcFilePath;
    }

    public String getDestFilePath() {
        return destFilePath;
    }

    public void setDestFilePath(String destFilePath) {
        this.destFilePath = destFilePath;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Message() {
    }

    public Message(String sender, String receiver, String content, String sendTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sendTime = sendTime;
    }
}
