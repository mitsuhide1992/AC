package com.java;

public class StringBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hello";
		String s2 = new String ("hello");
		String s3 = "he" + "llo";
		final String s4 = "he";
		String s5 = s4 + "llo";
		System.out.println(s1.equals(s2));
		System.out.println(s3 ==  s5);
//		final String s3 = "lkl";
//		s3 += "sdf";
	}

}
