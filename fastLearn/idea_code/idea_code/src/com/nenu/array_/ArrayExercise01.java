package com.nenu.array_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise01 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("青年文摘~", 5);
        books[2] = new Book("金瓶梅新", 90);
        books[3] = new Book("java从入门到放弃", 300);
//        Book.sort(books, new Comparator() {
//            @Override     //自己创建的函使用Comparator
//            public int compare(Object o1, Object o2) {
//                int n1 = (Integer) o1;
//                int n2 = (Integer) o2;
//                return n1 - n2;   //从小到大排序
//            }
//        });

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book)o1;
                Book book2 = (Book)o2;
//                return book1.getPrice()-book2.getPrice(); //价格升序
//                return book2.getPrice()-book1.getPrice();   //价格降序
                return book1.getName().length() - book2.getName().length(); //名字长度升序
            }
        });

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }
}

class Book {
    private String name;
    private int price;
    private static Book temp;

    public static void sort(Book[] books, Comparator c) {
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j].price, books[j + 1].price) > 0) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
