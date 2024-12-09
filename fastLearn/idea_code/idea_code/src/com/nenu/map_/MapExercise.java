package com.nenu.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Employee employee1 = new Employee("marry", 15000, "5001");
        Employee employee2 = new Employee("jack", 40000, "5002");
        Employee employee3 = new Employee("smith", 27000, "5003");

        HashMap hashMap = new HashMap();
        hashMap.put(employee1.getId(), employee1);
        hashMap.put(employee2.getId(), employee2);
        hashMap.put(employee3.getId(), employee3);

        //遍历hashMap
        System.out.println("========hashMap的增强for遍历=========");
        Set entrySet = hashMap.entrySet();
        for (Object entry : entrySet) {
            Map.Entry o = (Map.Entry) entry;
            Employee key = (Employee) o.getValue();
            if (key.getSal() > 18000) {
                System.out.println(key);
            }
        }

        System.out.println("========keySet的增强迭代遍历=========");
        Set keyset = hashMap.keySet();
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Employee e = (Employee) hashMap.get(key);
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private String id;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee(String name, double sal, String id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }
}
