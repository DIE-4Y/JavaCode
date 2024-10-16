package test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        int max , min;
        arr = getScore();
        max = getMax(arr);
        min = getMin(arr);
        int ave = 0;
        for (int i = 0; i < arr.length; i++) {
            ave += arr[i];
        }
        ave -= (max+min);
        ave /= 4;
        System.out.println();
    }

    public static int getMin(int[] arr){
        int[] arr2 = new int[6];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min < arr2[i]){
                min = arr2[i];
            }
        }
        return min;
    }

    public static int getMax(int[] arr){
        int[] arr1 = new int[6];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr1[i]){
                max = arr1[i];
            }
        }
        return max;
    }

    public static int[] getScore(){
        int [] arr = new int [6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length;) {
            int score = sc.nextInt();
            if(score >= 0 && score <= 100){
                arr[i++] = score;
            }
        }
        return arr;
    }

}
