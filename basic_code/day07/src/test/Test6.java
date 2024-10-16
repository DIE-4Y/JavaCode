package test;

import java.util.Scanner;

public class Test6 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int ret = sc.nextInt();
        int len = getLen(ret);
        int[] arr = getArr(len, ret);
        arr = step1(arr);
        arr = step2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int getLen(int ret){
        int len = 0;
        while(ret != 0){
            ret /= 10;
            len++;
        }
        return len;
    }
    public static int[] getArr(int len, int ret){
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = ret % 10;
            ret /= 10;
        }
        return arr;
    }

    public static int[] step1(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 5;
            arr[i] %= 10;
        }
        return arr;
    }


    public static int[] step2(int[] arr){
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
