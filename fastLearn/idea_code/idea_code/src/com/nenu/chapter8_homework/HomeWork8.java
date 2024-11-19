package com.nenu.chapter8_homework;

public class HomeWork8 {
    public static void main(String[] args) {
        SavingAccount sa1 = new SavingAccount(8000);
        sa1.deposit(300);
        sa1.deposit(300);
        sa1.deposit(300);
        sa1.deposit(300);
        sa1.withdraw(500);
        System.out.println(sa1.getBalance());
        sa1.earnMonthlyInterest();
        System.out.println(sa1.getBalance());

    }
}

