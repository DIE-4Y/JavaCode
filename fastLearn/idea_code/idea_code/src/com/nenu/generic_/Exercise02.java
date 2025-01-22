package com.nenu.generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercise02 {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(2000, 12, 1);
        MyDate date2 = new MyDate(1990, 4, 13);
        MyDate date3 = new MyDate(1998, 7, 20);
        Employee employee1 = new Employee("Jack", 2700, date1);
        Employee employee2 = new Employee("Marry", 3000, date2);
        Employee employee3 = new Employee("Smith", 3300, date3);


        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee2);
        employees.add(employee1);
        employees.add(employee3);
        employees.add(new Employee("Jack", 2700, new MyDate(2002, 11, 30)));
        //排序前
        System.out.println("====排序前====");
        System.out.println(employees);
        System.out.println("====排序后====");
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //名字排序
                int res = o1.getName().compareTo(o2.getName());
                if (res != 0) {
                    return res;
                }
                //生日排序
                res = o1.getBirthday().getYear() - o2.getBirthday().getYear();
                if (res != 0) {
                    return res;
                }
                res = o1.getBirthday().getMoth() - o2.getBirthday().getMoth();
                if (res != 0) {
                    return res;
                }
                res = o1.getBirthday().getDay() - o2.getBirthday().getDay();
                if (res != 0) {
                    return res;
                }
                return 0;
            }

        });
        System.out.println(employees);
    }
}

class Employee {

    private String name;
    private double sal;
    private MyDate birthday;

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

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}' + "\n";
    }
}

class MyDate {
    private int moth;
    private int day;
    private int year;

    public MyDate(int moth, int day, int year) {
        this.moth = moth;
        this.day = day;
        this.year = year;
    }

    public int getMoth() {
        return moth;
    }

    public void setMoth(int moth) {
        this.moth = moth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return moth +
                "-" + day +
                "-" + year;
    }
}