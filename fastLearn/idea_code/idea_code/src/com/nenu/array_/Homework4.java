package com.nenu.array_;

//判断字符串里有几个大写小写字母和数字
public class Homework4 {
    public static void main(String[] args) {
        String str = "asdng923nASADfb9I";
        if (str == null) {
            System.out.println("字符串不能为空");
            return;
        }
        int[] result = judge(str);
        System.out.println(String.format("小写字母%d个,大写字母%d个,数字%d个", result[0], result[1], result[2]));
    }

    public static int[] judge(String str) {
        int[] result = new int[3];
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= 'a' && chs[i] <= 'z') {
                result[0]++;
            } else if (chs[i] >= 'A' && chs[i] <= 'Z') {
                result[1]++;
            } else if (chs[i] >= '0' && chs[i] <= '9') {
                result[2]++;
            }
        }
        return result;
    }
}
