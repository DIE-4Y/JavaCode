package com.nenu.equals_;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person person1 = new Person("张三", 20, '男');
        Person person2 = new Person("李九", 40, '男');
        Person person3 = new Person("李九", 40, '男');
        System.out.println("person1 equals person3 is " + person1.equals(person2));
        System.out.println("person2 equals person3 is " + person2.equals(person3));
    }
}
