package com.nenu.socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP实现接收B的数据 -- 端口为：9999
 * 如果是"四大名著是哪些"就返回
 * 否则返回what
 */
public class HomeworkA01 {
    public static void main(String[] args) throws IOException {
        String ip = "10.90.175.227";
        //等待数据包
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //接收数据包
        byte[] bytes=new byte[1024*64];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(datagramPacket);
        //拆包
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, datagramPacket.getLength());
        if("四大名著是哪些".equals(s)){
            bytes = "四大名著是《红楼梦》...".getBytes();
            datagramPacket = new DatagramPacket(bytes,0, bytes.length, InetAddress.getByName(ip), 8888);
            datagramSocket.send(datagramPacket);
        }else {
            bytes = "叽里咕噜说啥呢？？？".getBytes();
            datagramPacket = new DatagramPacket(bytes,0, bytes.length, InetAddress.getByName(ip), 8888);
            datagramSocket.send(datagramPacket);
        }
        System.out.println("已返回消息");
        //关闭资源
        datagramSocket.close();
        System.out.println("A已关闭");
    }
}
