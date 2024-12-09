package com.nenu.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkSetExercise01 {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("BMW", 500000));
        linkedHashSet.add(new Car("BMW", 500000));
        linkedHashSet.add(new Car("BMWx5", 400000));
        linkedHashSet.add(new Car("BMW", 400000));
        linkedHashSet.add(new Car("BMWx5", 500000));
        linkedHashSet.add(new Car("BMWx5", 500000));
        System.out.println(linkedHashSet);
    }
}

class Car {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(getPrice(), car.getPrice()) == 0 && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
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

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
