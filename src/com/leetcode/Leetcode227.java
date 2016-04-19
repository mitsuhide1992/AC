package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Leetcode227 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode227 lc = new Leetcode227();
		String cal = "23 * 23 + 43 * 92";
		System.out.println(lc.calculate(cal));
	}
	
	public int calculate(String s) {
		char [] calInfo = s.toCharArray();
        ArrayList<Integer> num = new ArrayList<Integer>();
        ArrayList<Character> oper = new ArrayList<Character>();
        String IntS = "";
        for (int i = 0; i < calInfo.length; i++) {
        	if (calInfo[i] == '/' || calInfo[i] == '*') {
        		int lastIndex = num.size()-1;
        		int num1 = num.get(lastIndex);
        		num.remove(lastIndex);
        		char op = calInfo[i];
        		while (calInfo[i + 1] == ' ') {
        			i++;
				}
        		while (i != calInfo.length - 1 && calInfo[i + 1] >= '0' && calInfo[i + 1] <= '9') {
        			IntS = IntS + calInfo[i + 1];
        			i++;
				}
        		int num2 = Integer.valueOf(IntS);
        		IntS = "";
        		int num3 = op == '/' ? num1 / num2 : num1 * num2;
        		num.add(num3);
        	} else if (calInfo[i] == '+' || calInfo[i] == '-') {
        		oper.add(calInfo[i]);
        	} else if (calInfo[i] != ' ') {
        		if (i == calInfo.length - 1 || calInfo[i + 1] < '0' || calInfo[i + 1] > '9') {
        			num.add(Integer.valueOf(IntS + calInfo[i]));
        			IntS = "";
        		} else {
        			IntS = IntS + calInfo[i];
        		}
        	}
        }
        
        int i = 0;
        int start = 0;
        int end = num.size() - 1;
        while (start < end) {
        	int num1 = num.get(i);
    		int num2 = num.get(i + 1);
    		int num3 = oper.get(i) == '+' ? num1 + num2 : num1 - num2;
    		num.set(i + 1, num3);
    		start = i + 1;
    		i++;
		}
        return num.isEmpty() ? 0 : num.get(end);
    }
}
