package edu.nenu;

import java.util.HashSet;

public class LonggestUnsameSubString {
	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstring(String s) {
		HashSet<Character> set = new HashSet<>();
		int res = 0;
		for (int l = 0, r = 0; r < s.length(); ++r) {
			Character c = s.charAt(r);
			while (set.contains(c)) {
				set.remove(s.charAt(l));
				++l;
			}
			set.add(c);
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
