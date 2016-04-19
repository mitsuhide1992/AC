package com.leetcode;

import java.util.HashMap;

public class Leetcode290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode290 lc = new Leetcode290();
		System.out.print(lc.wordPattern("ab", "dog dog"));
	}
	
	public boolean wordPattern(String pattern, String str) {
		HashMap<String, String> sMap = new HashMap<String, String>();
		HashMap<String, String> rMap = new HashMap<String, String>();
		String [] strs = str.split(" ");
		if (strs.length == 0) {
			return pattern.equals("") ? true : false;
		}
		if (strs.length != pattern.length()) {
			return false;
		}
		
		for (int i = 0; i < pattern.length(); i++) {
			String ch = String.valueOf(pattern.charAt(i));
			String chs = sMap.get(ch);
			String chr = rMap.get(strs[i]);
			if (chs == null && chr != null || chr == null && chs != null) {
				return false;
			}
			if (chs != null && chr != null) {
				if (!chs.equals(strs[i])) {
					return false;
				}
				if (!chr.equals(ch)) {
					return false;
				}
			} else if (chs == null && chr == null) {
				sMap.put(ch, strs[i]);
				rMap.put(strs[i], ch);
			}
		}
		return true;
    }
}
