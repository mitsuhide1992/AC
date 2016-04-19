package com.algorithm;

public class HeapSort {
	public static void main (String [] args) {
		int [] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		heapSort(array);
		for (int i = 0 ;i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}
	
	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		} else {
			buildMaxHeap(array);
			for (int i = array.length - 1; i >= 0 ;i--) {
				int temp = array[0];
				array[0] = array[i];
				array[i] = temp;
				maxHeap(array, i, 0);
			}
		}
	}
	
	public static void buildMaxHeap (int [] array) {
		if (array == null || array.length <= 1) {
			return;
		} else {
			int half = array.length / 2;
			for (int i = half; i >= 0; i--) {
				maxHeap(array, array.length, i);
			}
		}
	}
	
	public static void maxHeap(int [] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		} 
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}
		
		if (largest != index) {
			int temp = array[largest];
			array[largest] = array[index];
			array[index] = temp;
			maxHeap(array, heapSize, largest);
		}
	}
}
