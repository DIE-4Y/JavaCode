package com.nenu.reflect_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射修改PrivateTest的name并调用getName()打印
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取PrivateTest类 2种方法获取对应的Class对象
        Class<?> testClass = Class.forName("com.nenu.reflect_.PrivateTest");
        //Class<PrivateTest> testClass = PrivateTest.class;

        //创建一个PrivateTest对象实例
        Object o = testClass.newInstance();
        //设置PrivateTest的name属性 由于是私有属性只能用getDeclaredField
        Field name = testClass.getDeclaredField("name");
        //设置属性值 由于是private属性必须进行爆破才能操作 且不是static属性 必须传入对象
        name.setAccessible(true);
        name.set(o, "张三");
        //获取方法 由于是public方法getMethod和getDeclaredMethod都能使用 原方法没有参数 不用传入参数的class
        Method getName = testClass.getMethod("getName");
        //传入对象调用方法
        System.out.println("newName = "+getName.invoke(o));;
    }
}

class PrivateTest {
    private String name = "hellokitty";
    public String getName(){
        return name;
    }
}