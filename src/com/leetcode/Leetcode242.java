package com.leetcode;

import java.util.Arrays;

public class Leetcode242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAnagram(String s, String t) {
		char [] arr1 = s.toCharArray();
		char [] arr2 = t.toCharArray();
		if (arr1.length != arr2.length) {
			return false;
		}
		if (arr1.length == 0 && arr2.length == 0) {
			return true;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0 ; i < arr1.length && i < arr2.length; i++) {
			if (arr1[i] != arr2[i]) return false; 
		}
		return true;
    }
	 
}
