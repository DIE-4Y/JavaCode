package com.nenu.encapsulation;

public class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("名字长度不在范围内（2——4），设为默认名字——无名氏");
            this.name = "无名氏";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 20) {
            this.balance = balance;
        } else {
            System.out.println("余额少于20，设为默认300");
            this.balance = 300;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() >= 6) {
            this.password = password;
        } else {
            System.out.println("密码不到6位，设为666666");
            this.password = "666666";
        }
    }

    public void getInfor() {
        System.out.println(this.name + "的余额是" + this.getBalance() + ",他的密码是" + this.getPassword());
    }
}
