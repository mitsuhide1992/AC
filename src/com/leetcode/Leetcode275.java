package com.leetcode;

public class Leetcode275 {
	
	public static void main(String [] args) {
		Leetcode275 lc = new Leetcode275();
		int [] nums = {1, 2, 3, 4, 5};
		System.out.println(lc.hIndex(nums));
	}
	
	public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
		if (citations.length == 1) {
			if (citations[0] >= 1) return 1;
			else return 0;
		}
		
		int low = 0;
		int high = citations.length - 1;
		int mid = (low + high) / 2;
		int count = citations.length - mid;
		boolean finished = false;
		while (low <= high && !finished) {
			finished = true;
			if (citations[mid] < count) {
				low = mid + 1;
				mid = (mid + 1 + high)/2;
				finished = false;
			} else if(mid >= 1 && citations[mid - 1] > count) {
				high = mid - 1;
				mid = (mid - 1 + low)/2;
				finished = false;
			} 
			count = citations.length - mid;
			if (low > high) return 0;
		}
		return count;
    }
}
