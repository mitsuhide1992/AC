package com.leetcode;

import java.util.Arrays;

public class Leetcode239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,  3,  -1, -3,  5,  3,  6,  7};
		Leetcode239 lc = new Leetcode239();
		int [] re = lc.maxSlidingWindow(nums, 3);
		for (int item : re) {
			System.out.print(item + " ");
		}
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) return new int[0];
		for (int i = 1 ; i < k; i++) {
			int l = nums.length - i;
			for (int j = 0; j < l; j++) {
				nums[j] = Math.max(nums[j], nums[j + 1]);
			}
		}
		return Arrays.copyOf(nums, nums.length - k + 1);
    }

}
