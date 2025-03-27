package com.nenu.socket_;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * UDP实现向A发送数据 端口为 ：8888
 * 并打印A发送的数据
 */
public class HomeworkB01 {
    public static void main(String[] args) throws IOException {
        String ip = "10.90.175.227";
        //发送UDP数据包
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] bytes;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题（四大名著是哪些）：");
        bytes = scanner.next().getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName(ip), 9999);
        datagramSocket.send(datagramPacket);
        System.out.println("数据已发送");
        //接收数据
        bytes = new byte[1024];
        datagramPacket = new DatagramPacket(bytes,0,1024);
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, datagramPacket.getLength()));

        //关闭资源
        datagramSocket.close();
        System.out.println("B已关闭");
    }
}
