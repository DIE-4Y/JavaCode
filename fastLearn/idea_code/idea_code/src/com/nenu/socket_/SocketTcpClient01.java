package com.nenu.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTcpClient01 {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        //向服务端发送数据
        outputStream.write("hello,server".getBytes());
        //设置结束标记
        socket.shutdownOutput();
        //打印服务端发送的数据
        InputStream inputStream = socket.getInputStream();
        byte[] data = new byte[1024];
        int line = 0;
        while ((line = inputStream.read(data)) != -1) {
            System.out.println(new String(data, 0, line));
        }
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
