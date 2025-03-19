package com.nenu.file_;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /*
     * 实现图片拷贝
     * 1.FileInputStream读入一段数据
     * 2.FileOutputStream写入一段数据
     */
    @Test
    public void fileCopy01() {
        String srcFilePath = "C:\\Users\\faker\\Pictures\\Saved Pictures\\未知画家\\jingliu_honkai_and_1_more_drawn_by_silverfox_ho.jpg";
//        File srcFile = new File(srcFilePath);
        String destFilePath = "D:\\桌面\\jingliu.jpg";
//        File destFile = new File(destFilePath);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            byte[] readData = new byte[1024];
            int readLen = 0;
            //输入输出流可以不传文件对象而直接传入文件路径
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            while ((readLen = fileInputStream.read(readData))!= -1){
                fileOutputStream.write(readData, 0, readLen);
            }
            System.out.println("图片拷贝成功,路径："+destFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null){
                    fileOutputStream.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
