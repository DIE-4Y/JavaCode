package com.nenu.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//使用字符流
public class SocketTcpClient02 {
    public static void main(String[] args) throws IOException {
        //建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        //向服务端发送数据
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server 字符流1");
        bufferedWriter.newLine();
        bufferedWriter.write("hello,server 字符流2");
        bufferedWriter.newLine();
        bufferedWriter.write("hello,server 字符流3");
        //加上换行符可表示一次通信结束不用结束标志 但是读入只能用readLine()
        bufferedWriter.newLine();
        bufferedWriter.flush();//必须刷新否则可能出现异常
        socket.shutdownOutput();
        //打印服务端发送的数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());
        //关闭流和socket
        outputStream.close();
        bufferedReader.close();
        socket.close();
    }
}
