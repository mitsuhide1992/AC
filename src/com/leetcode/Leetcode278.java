package com.leetcode;

public class Leetcode278 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	public int firstBadVersion(int n) {
//		if (n == 1) return 1;
//		int low = 1;
//		int high = n;
//		int mid = (low + high) / 2;
//		while (low < high) {
//			boolean isBad = isBadVersion(mid);
//			if (isBad) {
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//			mid = (low + high) / 2;
//		}
//		
//		return isBadVersion(low) ? low : low + 1;
//    }
}
