package com.nenu.file_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 1.编写一个dog.properties name=tom, age=5, color = red
 * 2.编写一个Dog类(name,age,color)
 * 3.创建一个dog对象,读入dog.properties相应内容并输入
 */
public class Homework03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\com\\nenu\\file_\\dog.properties"));
        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")),properties.getProperty("color"));
        System.out.println(dog);
    }
}
