package com.nenu.chapter8_homework;

public class HomeWork10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("马牛逼", 40, "高能物理", "母", 40000);
        Doctor doctor2 = new Doctor("马牛逼", 40, "高能物理", "母", 40000);
        Doctor doctor1 = new Doctor("刀哥", 50, "母猪的产后护理", "雄性", 20000);
        System.out.println("doctor1.equals(doctor) is " + doctor1.equals(doctor));
        System.out.println("doctor2.equals(doctor) is " + doctor2.equals(doctor));
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private String gender;
    private double salary;


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Doctor) {
            if (((Doctor) obj).getName().equals(this.getName()) && (((Doctor) obj).getAge() == this.getAge()) && (((Doctor) obj).getGender()).equals(this.getGender()) && (((Doctor) obj).getSalary()) == this.getSalary()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Doctor(String name, int age, String job, String gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }

    public Doctor() {
    }
}