package test;

public class GIrfriendTest {
    public static void main(String[] args) {
        Girfriend girfriend = new Girfriend();
        girfriend.setName("小红");
        girfriend.setGender("female");
        girfriend.setAge(19);
        girfriend.eat();
        girfriend.sleep();
        System.out.println(girfriend.getName());
        System.out.println(girfriend.getAge());
        System.out.println(girfriend.getGender());
    }
}
