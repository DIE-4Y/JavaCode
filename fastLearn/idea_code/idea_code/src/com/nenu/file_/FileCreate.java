package com.nenu.file_;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    /*
     * 方式1：直接用路径创建
     */
    @Test
    public void create01(){
        String filePath = "D:\\news01.txt";
        //这个文件对象在内存中并未在磁盘创建
        File file = new File(filePath);

        try {
            //必须调用createNewFile才能在磁盘创建文件
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * 方式2：采用父目录，子路径创建
     */
    @Test
    public void fileCreate02(){
        //转义路径可更换为 D:/ 等价于 D:\
        String parentPath = "D:\\";
        String childrenFile = "news02.txt";
        File file = new File(parentPath, childrenFile);

        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * 方式3：采用父目录文件，子目录创建
     */
    @Test
    public void fileCreate03(){
        File parentFile = new File("D:\\");
        String childrenPath = "news03.txt";
        File file = new File(parentFile, childrenPath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
