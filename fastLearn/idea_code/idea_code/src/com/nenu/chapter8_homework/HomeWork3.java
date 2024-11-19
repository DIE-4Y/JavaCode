package com.nenu.chapter8_homework;

public class HomeWork3 {
    public static void main(String[] args) {
        Teacher t1 = new Professor("丁真", 38, 20000);
        t1.introduce();
        t1 = new ViceProfessor("孙笑川", 40, 25000);
        t1.introduce();
        t1 = new Lecturer("王源", 35, 15000);
        t1.introduce();
    }
}

class Teacher {
    private String name;
    private int age;
    private String post = "Teacher";
    private double salary;

    public void introduce() {
        System.out.println("name: " + this.name + "\tage: " + this.age
                + "\tpost: " + this.post + "\tsalary: " + this.salary);
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Teacher() {
    }
}

class Professor extends Teacher {
    public Professor(String name, int age, double salary) {
        super(name, age, salary);
        super.setPost("Professor");

    }

    public void introduce() {
        System.out.println("name: " + getName() + "\tage: " + getAge()
                + "\tpost: " + getPost() + "\tsalary: " + getSalary() * 1.3);
    }

}

class ViceProfessor extends Teacher {
    public ViceProfessor(String name, int age, double salary) {
        super(name, age, salary);
        super.setPost("ViceProfessor");
    }


    public void introduce() {
        System.out.println("name: " + getName() + "\tage: " + getAge()
                + "\tpost: " + getPost() + "\tsalary: " + getSalary() * 1.2);
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, double salary) {
        super(name, age, salary);
        super.setPost("Lecturer");
    }


    public void introduce() {
        System.out.println("name: " + getName() + "\tage: " + getAge()
                + "\tpost: " + getPost() + "\tsalary: " + getSalary() * 1.1);
    }

}