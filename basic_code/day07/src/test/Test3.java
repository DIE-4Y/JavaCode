package test;

import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        char[] chs = new char[52];
        String result = new String();
        for (int i = 0; i < chs.length; i++) {
            if(i <= 25){
                chs[i] = (char)('a' + i);
            }
            else {
                chs[i] = (char)('A'-26 + i);
            }
         }
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int  radomindex = r.nextInt(chs.length);
            result += chs[radomindex];
        }
        int number = r.nextInt(10);
        result += number;
        System.out.println(result);
    }
}
