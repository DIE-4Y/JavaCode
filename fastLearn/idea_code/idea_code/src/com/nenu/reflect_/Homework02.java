package com.nenu.reflect_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射操作File进行文件创建
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获得File的Class对象
        Class<?> fileClass = Class.forName("java.io.File");
        //打印File的所有构造器
        Constructor<?>[] fileConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> fileConstructor : fileConstructors) {
            System.out.println("File的所有构造器："+fileConstructor.toString());
        }
        System.out.println("============================");
        //使用有参构造创建File对象并调用方法创建文件
        Constructor<?> constructor = fileClass.getConstructor(String.class);
        Object o = constructor.newInstance("D:\\桌面\\a.txt");
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}
