package com.nenu.generic_;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

public class Exercise01 {
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<Student>();
        hashSet.add(new Student("张三", 20));
        hashSet.add(new Student("李四", 28));
        hashSet.add(new Student("赵五", 23));
        System.out.println("=======hashSet========");
        for (Student student : hashSet) {
            System.out.println(student);
        }

        HashMap<String, Student> map = new HashMap<String, Student>();
        map.put("Jack", new Student("张三", 20));
        map.put("Tom", new Student("李四", 28));
        map.put("Smith", new Student("赵五", 23));
        System.out.println("=========hashMap========");
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(map.get(next));

        }

    }
}


class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}