package test;

public class GameTest {
    public static void main(String[] args) {
        Role r1 = new Role("穆某", 100, '男');
        Role r2 = new Role("李某", 100, '男');
        r1.showInform();
        r2.showInform();
        while (true){
            r1.attack(r2);
            if(r2.getBlood() == 0){
                System.out.println(r1.getName() + "KO了" + r2.getName());
                break;
            }
            r2.attack(r1);
            if(r1.getBlood() == 0){
                System.out.println(r2.getName() + "KO了" + r1.getName());
                break;
            }
        }
    }
}
