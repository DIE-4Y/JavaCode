package com.nenu.list_;

import java.util.ArrayList;
import java.util.Iterator;

public class ListExercise01 {
    public static void main(String[] args) {
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("hello");
        arrayList1.add(1);
        arrayList1.add("world");
        arrayList1.add(2);
        arrayList1.add("你好");
        arrayList1.add(3);
        arrayList1.add("世界");
        arrayList1.add(4);
        arrayList1.add(new String("东师"));
        arrayList1.add("nenu");
        arrayList1.add(5);
        //列表指定位置插入对象
        arrayList1.add(2, "喊顺平教育");
        //获得第五个元素
        System.out.println("获得第五个元素:"+arrayList1.get(5));
        //删除第六个
        arrayList1.remove(6);
        //修改第七个
        arrayList1.set(6,new String("我是刀哥"));
        //迭代器遍历
        System.out.println("=========迭代器开始遍历==========");
        Iterator iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}


