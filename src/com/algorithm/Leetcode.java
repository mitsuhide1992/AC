package com.algorithm;

public class Leetcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] words = {"abcdefghijklmnopqrstuvwxyz", "asdasdsaf"};
		Leetcode lc = new Leetcode();
		lc.maxProduct(words);
	}
	public int maxProduct(String[] words) {  
        int len = words.length;  
        if(len <=1 ) return 0;  
        int[] mask = new int[len];  
        for(int i=0;i<len;i++) {  
            for(int j=0;j<words[i].length();j++) {  
                mask[i] |= 1 << (words[i].charAt(j)-'a');  
            }  
        }  
        
        for (int i = 0; i < mask.length; i++) {
        	System.out.println(mask[i]);
        }
        int max = 0;  
        for(int i = 0;i < len; i++) {  
            for(int j = i+1; j < len; j++) {  
                if((mask[i] & mask[j]) == 0) {  
                    max = Math.max(max, words[i].length() * words[j].length());  
                }  
            }  
        }  
        return max;  
    }  
}
