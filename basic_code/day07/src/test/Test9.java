package test;

import java.util.Random;
import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        int[] arr = creatNumber();
        int[] userArr = userInput();
        int redCount = 0;
        int blueCount = 0;
        for (int i = 0; i < userArr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(userArr[i] == arr[j]){
                    redCount++;
                    break;
                }
            }
        }
        if(arr[arr.length - 1] == userArr[userArr.length - 1]){
            blueCount++;
        }
        if(redCount == 6 && blueCount == 1){
            System.out.println("1000万");
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("500万");
        } else if ((redCount == 5 && blueCount == 0) ||(redCount == 4 && blueCount == 1)) {
            System.out.println(200);
        } else if (redCount == 5 && redCount == 1) {
            System.out.println(3000);
        } else if ((redCount == 4) && (blueCount == 0) || (redCount == 3 && blueCount == 1)) {
            System.out.println(10);
        } else if ((redCount == 2 && blueCount == 1) || (redCount == 1 && blueCount == 1) || (redCount == 0 && blueCount == 1)) {
            System.out.println(5);
        }else{
            System.out.println("未中奖");
        }

    }

    public static int[] userInput() {
        int arr[] = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length - 1; ) {
            System.out.printf("请输入第%d个红球号码\n", i + 1);
            int redNumber = sc.nextInt();
            if (redNumber >= 1 && redNumber <= 33) {
                boolean flag = contain(arr, redNumber);
                if (!flag) {
                    arr[i] = redNumber;
                    i++;
                } else {
                    System.out.println("当前号码已存在");
                }
            } else {
                System.out.println("当前号码不存在");
            }
        }
        while (true) {
            System.out.println("请输入蓝球号码");
            int bulueNumber = sc.nextInt();
            if (bulueNumber >= 1 && bulueNumber <= 16) {
                arr[arr.length - 1] = bulueNumber;
                break;
            }
            else{
                System.out.println("当前号码错误");
            }
        }
        return arr;
    }
    public static int[] creatNumber(){
        int[] arr = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6;) {
            int redNumber = r.nextInt(33)+1;
            boolean flag = contain(arr, redNumber);
            if(!flag){
                arr[i] = redNumber;
                i++;
            }
        }
        int blueNumber = r.nextInt(16) + 1;
        arr[arr.length - 1] = blueNumber;
        return arr;
    }


    public static boolean contain(int[] arr, int number){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number){
                return true;
            }
        }
        return false;
    }
}
