package com.nenu.socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketTcpClient01 {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream outputStream = socket.getOutputStream();
        //向服务端发送数据
        outputStream.write("hello,world".getBytes());
        outputStream.close();
        socket.close();
    }
}
