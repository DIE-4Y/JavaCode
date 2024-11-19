package com.nenu.chapter8_homework;

public class JiaoShi extends YuanGong {
    private double keChou;
    private int day;

    public double getSalary() {
        return super.getSalary() + getKeChou() * getDay();
    }

    public double getKeChou() {
        return keChou;
    }

    public void setKeChou(double keChou) {
        this.keChou = keChou;
    }

    public JiaoShi(String name, double baseSalary, double keChou, int day) {
        super(name, baseSalary);
        this.keChou = keChou;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public JiaoShi() {
    }
}

class Scientist extends YuanGong{
    private double bonus;
    public double getSalary() {
        return super.getSalary() + getBaseSalary();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Scientist(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    public Scientist() {
    }
}