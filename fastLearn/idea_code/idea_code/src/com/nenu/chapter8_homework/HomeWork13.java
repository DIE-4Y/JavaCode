package com.nenu.chapter8_homework;

import com.nenu.equals_.Person;

public class HomeWork13 {
    public static void main(String[] args) {
        Person_[] p = new Person_[4];
        p[0] = new Student("小明", "雄性", 16, "123456");
        p[1] = new Student("小美", "雌性", 17, "123456");
        p[2] = new Teacher_("大明", "雄性", 30, 4);
        p[3] = new Teacher_("大美", "雌性", 34, 8);
        Sort sort = new Sort();
        sort.bubbleSort(p);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
        sort.userFunc(p);
    }
}

class Sort {
    public void bubbleSort(Person_[] p) {
        Person_ tem = null;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length - i - 1; j++) {
                if (p[i].getAge() < p[i + 1].getAge()) {
                    tem = p[i];
                    p[i] = p[i + 1];
                    p[i + 1] = tem;
                }
            }
        }
    }

    public void userFunc(Person_[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] instanceof Student) {
                ((Student) p[i]).study();
            } else if (p[i] instanceof Teacher_) {
                ((Teacher_) p[i]).teach();
            }
        }
    }
}

class Person_ {
    private String name;
    private String gender;
    private int age;

    public String paly() {
        return getName() + "爱玩";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person_(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Person_() {
    }
}

class Student extends Person_ {
    private String stu_id;

    public String paly() {
        return super.paly() + "篮球。";
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习！");
    }

    public Student(String name, String gender, int age, String stu_id) {
        super(name, gender, age);
        this.stu_id = stu_id;
    }

    public Student() {
    }
}

class Teacher_ extends Person_ {
    private int work_age;

    public String play() {
        return super.paly() + "象棋";
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会好好授课！");
    }

    public Teacher_(String name, String gender, int age, int work_age) {
        super(name, gender, age);
        this.work_age = work_age;
    }

    public Teacher_() {
    }
}
