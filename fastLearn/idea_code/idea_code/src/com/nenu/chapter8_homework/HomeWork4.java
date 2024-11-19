package com.nenu.chapter8_homework;

public class HomeWork4 {
    public static void main(String[] args) {
        Worker worker = new Worker("刀哥", 10, 700);
        Manager manager = new Manager("虎哥", 10, 800);
        showSalary showSalary = new showSalary();
        showSalary.showEmpSalary(worker);
        showSalary.showEmpSalary(manager);
    }
}

class showSalary {
    public void showEmpSalary(Employee e) {
        if (e instanceof Worker) {
            System.out.println("普通员工"+e.getName()+"的工资为：" + e.getSalary());
        } else if (e instanceof Manager) {
            System.out.println("经理"+e.getName()+"的工资为："+e.getSalary());
        } else {
            System.out.println("员工"+e.getName()+"的工资为： " + e.getSalary());
        }
    }
}
