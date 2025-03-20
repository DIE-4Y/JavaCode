package com.nenu.file_;

import java.io.*;

/**
 * 1.使用BufferedReader读取一个文本文件
 * 2.为每行加上行号，连同内功输入到屏幕上
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\桌面\\a.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int rows = 1;
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(rows + ": " + s);
            ++rows;
        }
        bufferedReader.close();
    }
}
