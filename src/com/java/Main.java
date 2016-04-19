package com.java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[] c = new char[n];
            String str = in.next();
            for (int i = 0; i < n; i++) {
                c[i] = str.charAt(i);
            }
            for (int i = 0; i < m; i++) {
                int index = in.nextInt();
                str = in.next();
                char c1 = str.charAt(0);
                c[index - 1] = c1;
                // funs
                System.out.println(fun(c));
            }
        }
    }
	
    public static int fun (char[] c) {
        int result = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if(c[i] == '.' &&  c[i + 1] == '.') {
                result++;
            }
        }
        return result;
    }
}
