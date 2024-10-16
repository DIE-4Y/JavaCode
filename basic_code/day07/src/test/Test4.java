package test;

public class Test4 {
    public static void main(String[] args) {
        int [] arr = {1 , 3, 5 ,7 ,8 , 4, 9, 7};
        int [] newarr = new int [arr.length];
        newarr = arr;
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            System.out.print(newarr[i]+" ");
        }
    }
}
