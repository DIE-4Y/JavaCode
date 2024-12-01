package com.nenu.array_;

public class Homework02 {
    public static void main(String[] args) {
        String username = "dz";
        String password = "676666";
        String email = "123@163.com";
        try {
            judge(username, password, email);
            System.out.println("符合要求，注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void judge(String username, String password, String email) {
        if (!(username != null && password != null && email != null)) {
            throw new RuntimeException("参数不完整");
        }
        if (!(username.length() >= 2 && username.length() <= 4)) {
            throw new RuntimeException("用户名长度应该2-4");
        }
        if (!(password.length() == 6 && isDigital(password))) {
            throw new RuntimeException("密码必须为6位且全部是数字");
        }
        int index1 = email.indexOf('@');
        int index2 = email.indexOf('.');
        if (!(index1 > 0 && index2 > 0 && index1 < index2)) {
            throw new RuntimeException("邮箱中必须包含@和. 且@必须在.前 ");
        }
    }

    public static boolean isDigital(String str) {
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!(chs[i] >= '0' && chs[i] <= '9')) {
                return false;
            }
        }
        return true;
    }
}
