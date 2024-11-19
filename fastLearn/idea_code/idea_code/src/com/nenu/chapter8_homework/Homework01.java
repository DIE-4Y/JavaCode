package com.nenu.chapter8_homework;

public class Homework01 {
    public static void main(String[] args) {
        Person[] p = new Person[3];

        //必须实例化对象
        p[0] = new Person();
        p[1] = new Person();
        p[2] = new Person();

        p[0].setName("小明");
        p[0].setAge(20);
        p[0].setJob("学生");

        p[1].setName("小强");
        p[1].setAge(30);
        p[1].setJob("工人");

        p[2].setName("小美");
        p[2].setAge(25);
        p[2].setJob("教师");

        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[i].getAge() > p[i + 1].getAge()) {
                    Person temp = p[i + 1];
                    p[i + 1] = p[i];
                    p[i] = temp;
                }
            }

        }
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    @Override
    public String toString() {
        return this.getName() + this.getAge() + this.getJob();
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person() {
    }
}
