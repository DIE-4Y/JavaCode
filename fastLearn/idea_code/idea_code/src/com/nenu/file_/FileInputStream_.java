package com.nenu.file_;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {

    public static void main(String[] args) {

    }

    /*
     * 使用read一次读入8bit
     */
    @Test
    public void readByByte() {
        File file = new File("D:\\桌面\\news01.txt");
        FileInputStream fileInputStream = null; //给文件指定一个IO流
        int ch = 0;
        try {
            fileInputStream = new FileInputStream(file);
            //一次读入一byte，read返回的是ASCII码值 如果读到文件末尾就返回-1
            while ((ch = fileInputStream.read()) != -1){
                System.out.print((char) ch);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /*
     * 使用read一次读入指定字节数
     */
    @Test
    public void readByBytes() {
        File file = new File("D:\\桌面\\news01.txt");
        FileInputStream fileInputStream = null; //给文件指定一个IO流
        //指定读入数组，一次8字节
        byte[] bytes = new byte[8];
        int len = 0;//每次读入的长度，最大为8
        try {
            fileInputStream = new FileInputStream(file);
            //一次读入一byte，read返回的是ASCII码值 如果读到文件末尾就返回-1
            while ((len = fileInputStream.read(bytes)) != -1){
                System.out.print(new String(bytes,0, len));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
