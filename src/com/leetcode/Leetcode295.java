package com.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode295 {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();//heap is a minimal heap by default
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//change to a maximum heap
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode295 lc = new Leetcode295();
		lc.addNum(3);
		lc.addNum(8);
		lc.addNum(1);
		lc.addNum(6);
		lc.addNum(5);
		lc.addNum(4);
		lc.addNum(7);
		lc.addNum(2);
		lc.addNum(9);
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//		minHeap.offer(3);
//		minHeap.offer(8);
//		minHeap.offer(1);
//		minHeap.offer(6);
//		minHeap.offer(5);
//		minHeap.offer(4);
//		minHeap.offer(7);
//		minHeap.offer(2);
//		minHeap.offer(9);
	}
	
	// Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
    
}
