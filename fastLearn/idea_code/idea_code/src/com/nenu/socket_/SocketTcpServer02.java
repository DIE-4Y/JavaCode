package com.nenu.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//使用字符流
public class SocketTcpServer02 {
    public static void main(String[] args) throws IOException {
        //接受连接监听9999窗口
        ServerSocket serverSocket = new ServerSocket(9999);
        //创建socket
        Socket socket = serverSocket.accept();
        //等待客户端传来的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //客户端没有使用socket.shutdownOutput()不能使用循环读入
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //向客户端发送数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server 字符流");
        //加上换行符可表示一次通信结束不用结束标志 但是读入只能用readLine()
        bufferedWriter.newLine();
        bufferedWriter.flush();//必须刷新否则可能出现异常

        //关闭流和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
