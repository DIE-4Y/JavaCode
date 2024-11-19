package com.nenu.chapter8_homework;

public class Employee {
    private String name;
    private int day;
    private double peerSalary;

    public double getSalary() {
        return day * peerSalary;
    }

    public Employee(String name, int day, double peerSalary) {
        this.name = name;
        this.day = day;
        this.peerSalary = peerSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getPeerSalary() {
        return peerSalary;
    }

    public void setPeerSalary(double peerSalary) {
        this.peerSalary = peerSalary;
    }

    public Employee() {
    }
}
