package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode241 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> diffWaysToCompute(String input) {
		List <Integer> allResult = new ArrayList<Integer>();
		HashSet<Integer> left = null;
		HashSet<Integer> right = null;
		HashSet<Integer> all = new HashSet<Integer>();
		
		char [] inputC = input.toCharArray();
		if (inputC.length == 0) {
			return allResult;
		}
		if (input.length() == 1) {
			allResult.add(Integer.valueOf(input));
			return allResult;
		}
		for (int i = 0; i < inputC.length - 2; i++) {
			left = charsValue(inputC, 0, i);
			right = charsValue(inputC, i + 2, inputC.length - 1);
			if (inputC[i + 1] == '-') {
				for (int le : left) {
					for (int ri : right) {
						all.add(le - ri);
					}
				}
			} else if (inputC[i + 1] == '*') {
				for (int le : left) {
					for (int ri : right) {
						all.add(le * ri);
					}
				}
			} else if (inputC[i + 1] == '+') {
				for (int le : left) {
					for (int ri : right) {
						all.add(le + ri);
					}
				}
			}
		}
		allResult.addAll(all);
		return allResult;
    }
	
	public HashSet<Integer> charsValue (char [] input, int low, int high) {
		return null;
//		HashSet <Integer> allResult = new HashSet<Integer>();
//		if (low < high) {
//			
//		} else if (low == high) {
//			allResult.add();
//		}
	}
}
