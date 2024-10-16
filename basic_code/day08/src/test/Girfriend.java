package test;

public class Girfriend {
    private String name;
    private int age;
    private String gender;
    public void setAge(int age){
        while(true) {
            if(age <= 20 && age >= 18){
                this.age = age;
                break;
            }
            else {
                System.out.println("年龄不符");
            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    public void eat(){
        System.out.println("吃饭");
    }
}
