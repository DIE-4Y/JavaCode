package com.nenu.house_rent.views;

import com.nenu.house_rent.utils.*;
import com.nenu.house_rent.service.HoseService;
import com.nenu.house_rent.domain.*;
import com.nenu.house_rent.utils.Util;

import java.util.Scanner;

public class HouseView {
    boolean loop = true;
    private int size = 10;
    HoseService hs = new HoseService(size);

    public void mainMenu() {
        do {
            System.out.println("============房屋出租系统==========");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出");
            System.out.print("请输入 （1-6）：");
            int key = Util.getNum();
            switch (key) {
                case 1:
                    houseAdd();
                    break;
                case 2:
                    houseSearch();
                    break;
                case 3:
                    houseDelete();
                    break;
                case 4:
                    houseAlter();
                    break;
                case 5:
                    houseList();
                    break;
                case 6:
                    System.out.println("6 退出");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误不在1-6之间");
            }
        } while (loop);
    }

    public void houseList() {
        System.out.println("============房屋出租信息==========");
        System.out.println("编号\t\t" + "姓名\t\t" + "电话\t\t" + "地址\t\t" + "租金\t\t" + "状态（已出租/未出租）");
        House[] houselist = hs.list();
        for (int i = 0; i < houselist.length; i++) {
            if (houselist[i] == null) {
                break;
            }
            System.out.println(houselist[i] + "\t");
        }

    }

    public void houseAdd() {
        System.out.println("============新增房源==========");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入名字：");
        String name = scanner.next();
        System.out.print("请输入电话：");
        String phone = scanner.next();
        System.out.print("请输入地址：");
        String address = scanner.next();
        System.out.print("请输入租金：");
        double rent = scanner.nextDouble();
        System.out.print("请输入状态（已出租/未出租）：");
        String status = scanner.next();
        House newHouse = new House(1, name, phone, address, rent, status);
        hs.add(newHouse);
    }

    public void houseDelete() {
        System.out.println("============删除房源==========");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要删除房屋的编号（-1退出）：");
        int id = scanner.nextInt();
        if (id == -1) {
            System.out.println("退出删除...");
            return;
        }
        System.out.print("是否确认要删除该房屋（y/n）：");
        char ch = scanner.next().charAt(0);
        if (ch != 'y') {
            System.out.println("输入错误删除失败...");
            return;
        }
        hs.delete(id);
    }

    public void houseSearch() {
        System.out.println("============查找房源==========");
        int id = -1;
        boolean flag = true;
        do {
            System.out.print("请输入一个大于0的整数：");
            id = Util.getNum();
            if(id >= 0){
                flag = false;
            }
        }while (flag);
        hs.search(id);
    }

    public void houseAlter(){
        System.out.println("============修改信息==========");
        int id = -1;
        boolean flag = true;
        do {
            System.out.print("请输入一个大于0的整数：");
            id = Util.getNum();
            if(id >= 0){
                flag = false;
            }
        }while (flag);
        hs.alter(id);
    }
}
