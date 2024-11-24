package com.nenu.enum_;

import java.util.Scanner;

public class Homework06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入前方道路（大河/小路）>>:");
        String path = scanner.next();
        Person person;
        if(path.equals("大河")){
            person = new Person("唐僧", VehicleFactory.getBoat());
        }else {
            person = new Person("唐僧", VehicleFactory.getHorse());
        }
        person.vehicles.work();
    }
}

class Person {
    private String name;
    Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

}

class VehicleFactory{
    public static Horse getHorse(){
        return new Horse();
    }

    public static Boat getBoat(){
        return new Boat();
    }
}

interface Vehicles{
    void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("马儿在跑");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("船在航行");
    }
}