package com.nenu.polyparameter_;

public class Manager extends Employee{

    double bonus = 20000;
    public void manage(){
        System.out.println("经理 "+ getName()+ "正在管理~~");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager() {
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getAnnual(){
        return super.getAnnual() + bonus;
    }
}
