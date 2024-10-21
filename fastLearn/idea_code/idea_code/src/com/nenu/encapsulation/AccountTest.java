package com.nenu.encapsulation;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setName("张三");
        account1.setBalance(230);
        account1.setPassword("098765");
        account1.getInfor();
        System.out.println("===================");
        Account account = new Account("zhangsan", 2, "123");;
        account.getInfor();
    }
}
