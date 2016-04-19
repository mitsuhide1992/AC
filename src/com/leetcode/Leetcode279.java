package com.leetcode;

public class Leetcode279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode279 lc = new Leetcode279();
//		System.out.println(lc.numSquares());
	}
	
	public int numSquares(int n) {
        int [] dp = new int [n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	int k = (int)Math.sqrt((double)i);
        	dp[i] = n;
        	for (int j = 1; j <= k; j++) {
        		dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        	}
        }
        return dp[n];
    }

}
