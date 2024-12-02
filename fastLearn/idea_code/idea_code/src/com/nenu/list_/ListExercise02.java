package com.nenu.list_;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExercise02 {
    public static void main(String[] args) {
//        List list1 = new ArrayList();
//        List list1 = new LinkedList();
        List list1 = new Vector();
        list1.add(new Book("三国志", 55.5));
        list1.add(new Book("封神榜", 35.7));
        list1.add(new Book("水浒传", 70.3));
        list1.add(new Book("西游记", 60.4));
        System.out.println("====排序前====");
        for (Object o :list1) {
            System.out.println(o);
        }
        System.out.println("====排序后====");
        listSort(list1);
        for (Object o :list1) {
            System.out.println(o);
        }


    }

    public static void listSort(List list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;

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

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + getName() + "\t\t价格" + getPrice();
    }
}