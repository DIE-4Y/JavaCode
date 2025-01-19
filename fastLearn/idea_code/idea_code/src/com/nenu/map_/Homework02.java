package com.nenu.map_;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework02 {
    public static void main(String[] args) {
        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("奔驰", 500000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(car1);
        arrayList.add(car2);
        System.out.println("=======添加======");
        for (Object o :arrayList) {
            System.out.println((Car)o);
        }
        System.out.println("=======移出下标为1======");
        arrayList.remove(1);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println((Car)next);
        }
        System.out.println("=======移出下标为1======");
        System.out.println("现在列表大小："+arrayList.size());;
        System.out.println();
    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
