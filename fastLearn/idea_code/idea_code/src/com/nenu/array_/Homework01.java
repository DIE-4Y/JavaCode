package com.nenu.array_;

//字符指定内串翻转
public class Homework01 {
    public static void main(String[] args) {
        String str = "本套Java视频教程非常适合零基础的学员";
        System.out.println("========原句子==========");
        System.out.println(str);
        System.out.println("========修改后==========");
        try {
            str = strReverse(str, 2, 5);
            System.out.println(str);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String strReverse(String str, int start, int end) {
        //添加异常处理 增加代码健壮性
        if (!(str != null && start >= 0 && end <= str.length() && start <= end)) {
            throw new RuntimeException("参数异常，请重新检查");
        }
        char[] chs = str.toCharArray(); //字符串是不能操纵的 必须先转成 字符串数组

        //字符串反转逻辑
        char temp;
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        //最后使用string将chs转化为string对象返回
        return new String(chs);
    }
}
