package com.nenu.socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * B端向A端发送数据
 * A端接收后向B端发送数据
 */
public class UDPTerminalA {
    public static void main(String[] args) throws IOException {
        //端口等待接收数据包
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //拆包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        System.out.println("等待接收B端数据");
        datagramSocket.receive(datagramPacket);
        //打印B端发送的信息
        byte[] data = datagramPacket.getData();
        int len = datagramPacket.getLength();
        String s = new String(data, 0, len);
        System.out.println(s);

        //向B端发送信息
        String ip = "10.90.175.227";
        data = "OK, I received".getBytes();
        DatagramPacket datagramPacket1 = new DatagramPacket(data, data.length, InetAddress.getByName(ip), 8888);
        datagramSocket.send(datagramPacket1);
        //关闭资源
        datagramSocket.close();
    }
}
