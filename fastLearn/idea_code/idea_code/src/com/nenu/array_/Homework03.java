package com.nenu.array_;

//将名字格式化输出
public class Homework03 {
    public static void main(String[] args) {
        String name = "fu RONG wang yuan";
        if(name == null){
            System.out.println("名字不能为空");
            return;
        }
        String []nList = name.split(" ");
        if (nList.length != 3){
            System.out.println("名字格式错误");
            return;
        }

        System.out.println(String.format("%s,%s.%c", nList[0], nList[2], nList[1].toUpperCase().charAt(0)));
    }
}


