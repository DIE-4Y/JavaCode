package com.nenu.chapter8_homework;

public class GongRen extends YuanGong {

    public double getSalary() {
        return super.getSalary();
    }

    public GongRen(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public GongRen() {
    }
}

class Farmer extends YuanGong {
    public double getSalary() {
        return super.getSalary();
    }

    public Farmer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public Farmer() {
    }
}

class Waiter extends YuanGong {
    public double getSalary() {
        return super.getSalary();
    }

    public Waiter(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public Waiter() {
    }
}
