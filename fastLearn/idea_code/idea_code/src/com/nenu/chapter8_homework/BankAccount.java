package com.nenu.chapter8_homework;

public class BankAccount {
    private double balance;

    //取款
    public void withdraw(double amount) {
        balance -= amount;
    }

    //存款
    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public BankAccount() {
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(double initialBalance) {
        setBalance(initialBalance);
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount() {
    }

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}

class SavingAccount extends BankAccount {
    private double rate = 0.001;
    private int times = 3;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public SavingAccount() {
    }

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void deposit(double amount) {
        if (times >= 1) {
            super.deposit(amount-1);
            times--;
        } else {
            super.deposit(amount);
        }
    }

    public void withdraw(double amount) {
        if (times >= 1) {
            super.withdraw(amount+1);
            times--;
        } else {
            super.withdraw(amount);
        }
    }

    public void earnMonthlyInterest() {
        super.deposit(getBalance()*rate);
        setTimes(3);
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }


}