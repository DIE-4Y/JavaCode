package com.nenu.polyparameter_;

public class Worker extends Employee{
    public void work(){
        System.out.println("普通员"+getName()+"工正在工作");
    }

    public Worker() {
    }

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public double getAnnual(){
        return super.getAnnual();
    }
}
