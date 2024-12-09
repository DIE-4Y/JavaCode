package com.nenu.set_;

import java.util.HashSet;
import java.util.Objects;

public class SetExercise02 {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate(2004, 10, 30);
        MyDate myDate2 = new MyDate(2000, 10, 5);
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee02("张三",4030.5, myDate1));
        hashSet.add(new Employee02("张三",6002.7, myDate1));
        hashSet.add(new Employee02("李四",4030.5, myDate2));
        hashSet.add(new Employee02("张三",555.55, myDate2));
        hashSet.add(new Employee02("李四",4030.5, myDate1));
        System.out.println(hashSet);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyDate)) return false;
        MyDate myDate = (MyDate) o;
        return getYear() == myDate.getYear() && getMonth() == myDate.getMonth() && getDay() == myDate.getDay();
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getYear(), getMonth(), getDay());
//    }

    @Override
    public String toString() {
        return year+"年"+month+"月"+day+"日";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

class Employee02 {
    private String name;
    private double sal;
    private MyDate birthday;

    @Override
    public String toString() {
        return "Employee02{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee02)) return false;
        Employee02 that = (Employee02) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getBirthday(), that.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee02(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
}
