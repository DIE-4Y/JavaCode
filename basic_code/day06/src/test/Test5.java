package test;

public class Test5 {
    public static void main(String[] args) {
        int []arr = {11, 22, 33, 44,55};
        printArr(arr);
    }

    public static void printArr(int [] arr){
        System.out.printf("[");
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
    }

}
