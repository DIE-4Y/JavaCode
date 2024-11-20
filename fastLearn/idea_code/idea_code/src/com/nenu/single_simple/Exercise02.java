package com.nenu.single_simple;

/**
 * 懒汉式
 * （1）属性私有化
 * （2）构造器私有化
 * （3）类变量只声明
 * （4）调用时判断是否创建对象（没有就创建，有就直接返回）
 */
public class Exercise02 {
    public static void main(String[] args) {

        Father fa1 = Father.getInstance();
        System.out.println(fa1);
        Father fa2 = Father.getInstance();
        System.out.println(fa2);
        System.out.println(fa1==fa2);
    }
}

class Father{
    private String name;
    private static Father fa;
    private Father(String name) {
        this.name = name;
    }

    public static Father getInstance() {
        if (fa == null){
            fa = new Father("陈");
        }
        return fa;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                '}';
    }
}