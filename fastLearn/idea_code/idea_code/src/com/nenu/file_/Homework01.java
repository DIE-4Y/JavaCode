package com.nenu.file_;


import java.io.File;
import java.io.IOException;

/**
 * 1.判断D盘是否存在mytemp文件夹，如果没有就创建
 * 2.在该目录下创建hello.txt文件，如果存在就停止创建
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        File dir = new File("d:\\桌面\\mytemp");
        if (!dir.exists()){
            System.out.println("正在创建目录");
             if(dir.mkdir()){
                 System.out.println("创建目录成功！");
             }else {
                 System.out.println("创建目录失败");
                 return;
             }
        }
        File file = new File(dir, "hello.txt");
        if(!file.exists()) {
            System.out.println("正在创建文件");
            if (file.createNewFile()) {
                System.out.println("文件创建成功");
            }else {
                System.out.println("文件创建失败");
            }
        }else {
            System.out.println("文件已存在");
        }
    }
}