package com.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class SetBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true);
		
		map.put("zly", "lsald");
		map.put("polo", "sdfsdf");
		map.put("mitsuhide", "rewxcv");
		map.put("masamune", "poasd");
		String po = map.get("polo");
		for (Entry<String, String> en : map.entrySet()) {
			System.out.print(en.getKey() + " ");
			System.out.println(en.getValue());
		}
	}
}
