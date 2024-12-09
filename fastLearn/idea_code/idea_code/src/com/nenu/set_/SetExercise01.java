package com.nenu.set_;

import java.util.HashSet;
import java.util.Objects;

/*
    (1)hash值变换
    (2)equals比较
    (3)都相等，添加失败,否则添加成功
 */

public class SetExercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println("jack添加" + hashSet.add(new Employee("jack", 18)));
        System.out.println("marray添加" + hashSet.add(new Employee("marry", 20)));
        System.out.println("jack添加" + hashSet.add(new Employee("jack", 18)));

    }
}


class Employee {
    private String name;
    private int age;

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

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() && Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }


    //    @Override
//    public int hashCode() {
//        return 100;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//
//        if (obj instanceof Employee) {
//            Employee e = (Employee) obj;
//            if (e.getName().equals(this.name) && e.getAge() == this.getAge()) {
//                return true;
//            }
//        }
//        return false;
//    }
}