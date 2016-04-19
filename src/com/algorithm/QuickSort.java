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
		int tmp = list[low];    //����ĵ�һ����Ϊ����  
        while (low < high) {  
            while (low < high && list[high] > tmp) {  
                high--;  
            }  
            list[low] = list[high];   //������С�ļ�¼�Ƶ��Ͷ�  
            while (low < high && list[low] < tmp) {  
                low++;  
            }  
            list[high] = list[low];   //�������ļ�¼�Ƶ��߶�  
        }  
        list[low] = tmp;              //�����¼��β  
        return low;                   //���������λ�� 
	}
	
	public void qSort(int [] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);
			qSort(list, low, middle - 1);
			qSort(list, middle + 1, high);
		}
	}
}	
