package com.nenu.house_rent.service;

import com.nenu.house_rent.domain.House;
import com.nenu.house_rent.utils.Util;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HoseService {
    private House[] houses;
    private int count = 1;
    private int id = 1;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //int id, String name, String phone, String address, double rent, String status
    public HoseService(int size) {
        this.houses = new House[size];
        houses[0] = new House(1, "张三", "19238495020", "海淀区", 9000, "已出租");
    }

    public House[] list() {
        return houses;
    }

    public void add(House newHose) {
        if (count >= houses.length) {
            System.out.println("房屋已满，新增房源失败...");
        } else {
            newHose.setId(++id);
            houses[count++] = newHose;
            System.out.println("============新增房源成功==========");
        }
    }

    public void delete(int id) {
        boolean flag = false;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                System.out.println("该房屋不存在...");
                return;
            }
            if (id == houses[i].getId()) {
                flag = true;
                count--;
                for (int j = i; j < houses.length - 1; j++) {
                    if (houses[j] == null) {
                        break;
                    }
                    houses[j] = houses[j + 1];
                }
                houses[count] = null;
                break;
            }
        }
        if (flag) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败，未找到该房屋");
        }
    }

    public void search(int id) {
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (houses[i].getId() == id) {
                System.out.println(("id为" + id + "的房屋信息如下："));
                System.out.println(houses[i]);
                flag = true;
                return;
            }
        }
        if (!flag) {
            System.out.println("未找到该id的房屋");
        }
    }

    public void alter(int id) {
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (houses[i].getId() == id) {
                //修改姓名
                System.out.print("姓名(" + houses[i].getName() + ")修改为：");
                String name = Util.getString();
                houses[i].setName(name);
                //修改电话
                System.out.print("电话("+houses[i].getPhone()+")修改为：");
                String phone = Util.getString();
                houses[i].setPhone(phone);
                //修改地址
                System.out.print("地址("+houses[i].getAddress()+")修改为：");
                String address = Util.getString();
                houses[i].setAddress(address);
                //修改租金
                System.out.print("租金("+houses[i].getRent()+")修改为：");
                Scanner scanner = new Scanner(System.in);
                double rent = scanner.nextDouble();
                houses[i].setRent(rent);
                //修改状态
                System.out.print("状态("+houses[i].getStatus()+")修改为：");
                String status = Util.getString();
                houses[i].setStatus(status);
                flag = true;
                System.out.println("修改完成...");
                return;
            }
        }
        if (!flag) {
            System.out.println("未找到该id的房屋");
        }
    }
}
