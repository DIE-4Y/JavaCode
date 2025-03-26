package com.nenu.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcpServer01 {
    public static void main(String[] args) throws IOException {
        //接受连接监听9999窗口
        ServerSocket serverSocket = new ServerSocket(9999);
        //创建socket
        Socket socket = serverSocket.accept();
        //等待客户端传来的数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int line = 0;
        while ((line=inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, line));
        }
        //向客户端发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        //设置结束标记
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
