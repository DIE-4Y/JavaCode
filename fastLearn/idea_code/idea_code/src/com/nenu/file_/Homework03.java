package com.nenu.file_;

import java.io.*;
import java.util.Properties;

/**
 * 1.编写一个dog.properties name=tom, age=5, color = red
 * 2.编写一个Dog类(name,age,color)
 * 3.创建一个dog对象,读入dog.properties相应内容并输入
 * 4.将dog序列化输出到dog.dat文件
 */
public class Homework03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\com\\nenu\\file_\\dog.properties"));
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")),properties.getProperty("color"));
        System.out.println(dog);

        //序列化需要传入流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\nenu\\file_\\dog.dat"));
        //序列化内容写入和取出需要顺序相同，写入的时候需要指定类型
        oos.writeObject(dog);
        oos.close();
    }
}
