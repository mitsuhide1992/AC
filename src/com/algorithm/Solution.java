package com.algorithm;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sl = new Solution();
//		String result = sl.trans("  ", 2);
//		System.out.println(result);
		System.out.println(sl.trans("Hello World asfdsd sdf  sSdSDSdf       DFDD ","Hello World asfdsd sdf  sSdSDSdf       DFDD ".length()));
		
//		int [][] land = {{1,1,1,1}, {0,0,0,0}, {1,0,1,1}};
//		
//		int [] result = sl.getPartition(land, 4, 3);
//		for (int item : result) {
//			System.out.print(item + " ");
//		}
	}
	
	public String trans (String s, int n) {
		if (n == 0) return "";
		int iterH = 0;
		String headBlank = "";
		String tailBlank = "";
//		while (iterH < n && s.charAt(iterH) == ' ') {
//			headBlank += " ";
//			iterH++;
//		}
//		if (iterH > 0)
//			iterH--;
//		int iterT = n - 1;
//		while (iterT > iterH && s.charAt(iterT) == ' ') {
//			iterT--;
//			tailBlank += " ";
//		}
		s = s.trim();
        String [] content = s.split(" ");
        String result = "";
        for (int i = 0; i < content.length;i++) {
            content[i] = exChange(content[i]);
            if (i == 0) {
                result = content[i];
            } else {
                result = content[i] + " " + result;
            }
        }
        return headBlank + result + tailBlank;
    }

    public String exChange (String str) {
        StringBuffer sb = new StringBuffer();
        if(str != null) {
            for(int i = 0;i < str.length(); i++){
                char c = str.charAt(i);
                if(Character.isUpperCase(c)){
                    sb.append(Character.toLowerCase(c));
                }else if(Character.isLowerCase(c)){
                    sb.append(Character.toUpperCase(c));
                }
            }
        }
        return sb.toString();
    }
    
    public int[] getPartition (int[][] land, int n, int m) {
        // write code here
    	int [] left = new int [n];
    	int [] right = new int [n];
    	int sumLeft = 0;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			right[i] += land[j][i];
    		}
    		left[i] = m - right[i];
    		sumLeft += left[i];
    	}
    	
    	int min = Integer.MAX_VALUE;
    	int sumRight = 0;
    	int divid = 0;
    	for (int i = 0; i <= n; i++) {
    		int sum = sumRight + sumLeft;
    		if (min > sum) {
    			min = sum;
    			divid = i;
    		}
    	}
    	int [] result = new int [2];
    	result[0] = divid;
    	result[1] = divid + 1;
    	return result;
    }
    
}
