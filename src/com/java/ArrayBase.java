package com.java;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("polo");
		ar.add("zly");
		ar.add("oasd");
		ar.add("mitsuhide");
		Iterator<String> iter = ar.iterator();
		while(iter.hasNext()) {
			String str = (String)iter.next();
			System.out.println(str);
		}
	}

}
