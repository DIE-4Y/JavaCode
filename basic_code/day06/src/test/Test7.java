package test;

public class Test7 {
    public static void main(String[] args) {
        int [] arr = {230 , 309, 50, 353, 493, 359};
        int num = 39;
        boolean result = contain(arr, num);
        System.out.println(result);
    }

    public static boolean contain(int [] arr, int num){
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }

}
