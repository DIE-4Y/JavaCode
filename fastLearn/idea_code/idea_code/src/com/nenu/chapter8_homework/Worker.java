package com.nenu.chapter8_homework;

public class Worker extends Employee {
    double rank = 1.0;
    public double getSalary() {
        return super.getSalary()*rank;
    }

    public Worker(String name, int day, double peerSalary) {
        super(name, day, peerSalary);
    }

    public Worker() {
    }
}
