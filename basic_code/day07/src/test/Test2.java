package test;

public class Test2 {
    public static void main(String [] args){
        int count = 0;
        for(int i = 101; i <= 200; i++) {
            boolean flag = true;
            for(int j = 2; j <= i/2; j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(i+"是质数");
                count++;
            }
            else{
                System.out.println(i+"不是质数");
            }
        }
        System.out.printf("有%d个质数", count);
    }

}
