package test;

public class Test8 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6,7,8,9};
        int[] copyarr = copyOfRange(arr, 4, 7);
        for(int i = 0; i < copyarr.length; i++){
            System.out.println(copyarr[i]);
        }
    }

    public static int[] copyOfRange(int [] arr, int fro, int to){
        int[] arr1 = new int[to - fro];
        for(int i = fro; i < to; i++){
            arr1[i - fro] = arr[i];
        }
        return arr1;
    }

}
