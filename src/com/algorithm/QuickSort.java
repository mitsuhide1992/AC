package com.algorithm;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {9,5,3,1,7,8,2,4,6,0};
		QuickSort qs = new QuickSort(); 
		qs.qSort(list, 0, list.length - 1);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i] + "");
		}
	}
	
	public  int getMiddle(int [] list, int low, int high) {	
		int tmp = list[low];    //数组的第一个作为中轴  
        while (low < high) {  
            while (low < high && list[high] > tmp) {  
                high--;  
            }  
            list[low] = list[high];   //比中轴小的记录移到低端  
            while (low < high && list[low] < tmp) {  
                low++;  
            }  
            list[high] = list[low];   //比中轴大的记录移到高端  
        }  
        list[low] = tmp;              //中轴记录到尾  
        return low;                   //返回中轴的位置 
	}
	
	public void qSort(int [] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			qSort(list, low, middle - 1);
			qSort(list, middle + 1, high);
		}
	}
}	
