package com.nenu.encapsulation;

public class Encap01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(200);
        person.setName("我是马牛逼我敢吃屎！");
        person.setSalary(40000.2);
        person.getInfor();
        Person 张麻子 = new Person("张麻子", -1, 2345.6);
        张麻子.getInfor();

    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        //构造器中使用set方法
        this.setName(name);
        setAge(age);
        setSalary(salary);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 6) {
            this.name = name;
        } else {
            System.out.println("名字太长，修改为无名氏");
            this.name = "无名氏";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 120 && age >= 1) {
            this.age = age;
        } else {
            System.out.println("年龄超出范围（1-120），修改为默认年龄30");
            this.age = 30;
        }
    }

    public double getSalary(String password) {
        if ("6666".equals(password)) {
            return salary;
        } else {
            System.out.println("密码错误，无法查看薪水");
            return -1;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void getInfor() {
        System.out.println(this.name + "的年龄是" + this.getAge() + ",他的薪水是" + this.getSalary("6666"));
    }
}
