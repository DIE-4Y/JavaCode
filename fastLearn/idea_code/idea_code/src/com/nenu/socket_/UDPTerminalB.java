package com.nenu.socket_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * A端向B端发送数据
 * B端接收后向A端发送数据
 */
public class UDPTerminalB {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //封装数据包
        String ip = "10.90.175.227";
        byte[] buf = "hello,接收到了吗".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(ip), 9999);
        //发送数据包
        datagramSocket.send(datagramPacket);
        //接收A端发送的数据包并解包打印
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        int len = datagramPacket.getLength();
        String s = new String(data, 0, len);
        System.out.println(s);
        //关闭资源
        datagramSocket.close();
    }
}
