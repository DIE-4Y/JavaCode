package test;

public class Test6 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 52, 0 ,98, 23};
        int max = getMax(arr);
        System.out.println(max);
    }

    public static int getMax(int [] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }

}
