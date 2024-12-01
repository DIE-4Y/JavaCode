package com.nenu.collection_;

import com.nenu.enum_.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise01 {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[3];
        dogs[0] = new Dog("刀哥", 40);
        dogs[1] = new Dog("虎哥", 35);
        dogs[2] = new Dog("小亮", 30);

        //ArrayList是存放列表的
        List doglist = new ArrayList();
        doglist.add(new Dog("刀哥", 40));
        doglist.add(new Dog("虎哥", 35));
        doglist.add(new Dog("小亮", 30));

        //迭代器实现遍历ArrayList
        //itit 快捷键生成迭代器遍历
        System.out.println("===========迭代器实现遍历ArrayList========");
        Iterator iterator = doglist.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Dog dog = (Dog) next;
            System.out.println("狗的名字："+dog.getName()+" 狗的年龄："+dog.getAge());
        }

        //for增强实现遍历
        System.out.println("===========for增强实现遍历ArrayList========");
        for(Object obj : doglist){
            Dog dog = (Dog) obj;
            System.out.println("狗的名字："+dog.getName()+" 狗的年龄："+dog.getAge());
        }
    }

}

class Dog {
    private String name;
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}