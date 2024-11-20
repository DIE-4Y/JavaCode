package com.nenu.single_simple;

/**
 * 饿汉式
 * 私有化构造器
 * 创建私有化类对象
 * 提供一个类函数返回
 */
public class Exercise01 {
    public static void main(String[] args) {
        System.out.println(GirlFriend.getInstance());
        GirlFriend gf1 = GirlFriend.getInstance();
        GirlFriend gf2 = GirlFriend.getInstance();
        System.out.println(gf1 == gf2);
    }
}


class GirlFriend {
    private String name;

    //创建私有化本类对象
    private static GirlFriend gf = new GirlFriend("Marry");

    //私有化构造器
    private GirlFriend(String name) {
        this.name = name;
    }

    //提供一个类函数返回
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
