package test;

import java.util.Random;

public class Test8 {

    public static void main(String[] args) {
        int arr[] = {2, 588, 888, 1000, 10000};
        speak(arr);
    }

    public static void speak(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            Random ra = new Random();
            int randomIndex = ra.nextInt(arr.length);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "已经被抽取");
        }
    }
}
