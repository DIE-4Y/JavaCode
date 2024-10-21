package com.nenu.polyparameter_;

public class PolyParameter {
    public static void main(String[] args) {
        Employee worker = new Worker("张麻子", 4000);
        Employee manager = new Manager("赵二狗", 4000, 50000);
        PolyParameter polyparameter = new PolyParameter();
        polyparameter.showEmpAnnual(worker);
        polyparameter.showEmpAnnual(manager);
    }

    public void showEmpAnnual(Employee e) {
        if (e instanceof Worker) {
            //这个向下转型 相当于 Worker worker = (Worker) e;
            ((Worker) e).work();
            System.out.println("普通员工 " + e.getName() + "的年薪是" + e.getAnnual());
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
            System.out.println("管理员 " + e.getName() + "的年薪是" + e.getAnnual());
        }
    }
}
