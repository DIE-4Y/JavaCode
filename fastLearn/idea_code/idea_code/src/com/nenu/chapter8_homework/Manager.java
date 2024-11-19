package com.nenu.chapter8_homework;

public class Manager extends Employee {

    double rank = 1.2;
    double bonus = 1000;

    public double getSalary() {
        return bonus + super.getSalary() * rank;
    }

    public Manager(String name, int day, double peerSalary) {
        super(name, day, peerSalary);
    }

    public Manager() {
    }
}
