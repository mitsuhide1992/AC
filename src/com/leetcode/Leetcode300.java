package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Leetcode300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {};
		Leetcode300 lc = new Leetcode300();
		System.out.print(lc.lengthOfLIS(a));
	}
	
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0)return 0;
		int [] lmax = new int [nums.length];
		int rmax = 1;
		lmax[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int tmax = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && tmax < lmax[j] + 1) {
					tmax = lmax[j] + 1;
				}
			}
			lmax[i] = tmax;
			if (rmax < tmax) {
				rmax = tmax;
			}
		}
		return rmax;
    }
}
