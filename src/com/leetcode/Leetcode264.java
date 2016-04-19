package com.leetcode;

public class Leetcode264 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode264 lc = new Leetcode264();
		System.out.println(lc.nthUglyNumber(7));
	}
	
	public int nthUglyNumber(int n) {
		int [] primes = {2, 3, 5};
		int [] pointer = new int [3];
		int [] ugly = new int [n];
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			int minP = 0;
			int minC = ugly[pointer[0]] * primes[0]; 
			for (int j = 1; j < 3; j++) {
				if (minC > ugly[pointer[j]] * primes[j]) {
					minC = ugly[pointer[j]] * primes[j];
					minP = j;
				} else if (minC == ugly[pointer[j]] * primes[j]) {
					pointer[j]++;
				}
			}
			ugly[i] = minC;
			pointer[minP]++;
		}
		return ugly[n - 1];
    }

}
