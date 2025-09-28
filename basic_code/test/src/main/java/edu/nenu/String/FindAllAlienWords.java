package edu.nenu.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: chenshanquan
 * @CreateTime: 2025-09-02
 * @Description: 找到字符串中所有字母异位词， 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词
 * 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 */

public class FindAllAlienWords {
    public static void main(String[] args) {
        String s = new String("cbaebabacd");
        String p = new String("abc");
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        // 待匹配的比目标的长，一定没有异位词
        if (plen > slen) {
            return new ArrayList<>();
        }
        int[] sChars = new int[26];
        int[] pChars = new int[26];
        List<Integer> ans = new ArrayList<>();
        // 遍历p串得到一个窗口
        for (int i = 0; i < plen; ++i) {
            ++pChars[p.charAt(i) - 'a'];
            ++sChars[s.charAt(i) - 'a'];
        }
        // 如果两个的前p长度出现字母次数相等就是异位词
        if (Arrays.equals(sChars, pChars)) {
            ans.add(0);
        }
        // 采用滑动窗口
        for (int i = 0; i < slen - plen; ++i) {
            --sChars[s.charAt(i) - 'a'];
            ++sChars[s.charAt(i + plen) - 'a'];
            if (Arrays.equals(sChars, pChars)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
