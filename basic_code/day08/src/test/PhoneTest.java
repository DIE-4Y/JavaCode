package test;

public class PhoneTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.brand = "锤子";
        p.price = 2300.0;
        System.out.println(p.brand);
        System.out.println(p.price);
        p.playGame();
        p.call();

        Phone p2 = new Phone();
        p2.brand = "沙币";
        p2.price = 30390.3;
        p.playGame();
        p.call();
    }
}
