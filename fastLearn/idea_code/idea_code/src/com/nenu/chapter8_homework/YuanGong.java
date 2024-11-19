package com.nenu.chapter8_homework;

public class YuanGong {
    private String name;
    private double baseSalary;
    public double getSalary() {
        return baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public YuanGong() {
    }

    public YuanGong(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
}
