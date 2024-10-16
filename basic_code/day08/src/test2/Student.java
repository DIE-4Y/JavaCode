package test2;

public class Student {
    private String name;
    private int age;

    public Student(int age , String name){
        this.age = age;
        this.name = name;
    }

    public Student(){
        System.out.println("look at me whether it worked");
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int  getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
}
