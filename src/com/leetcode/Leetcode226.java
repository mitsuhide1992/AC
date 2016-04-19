package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode226 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
		Queue<TreeNode> space = new LinkedList<TreeNode>();
        space.offer(root);
        while (!space.isEmpty()) {
        	TreeNode node = space.poll();
        	TreeNode left = node.left;
        	TreeNode right = node.right;
        	node.left = right;
        	node.right = left;
        	if (node.left != null) {
        		space.offer(node.left);
        	}
        	if (node.right != null) {
        		space.offer(node.right);
        	}
        }
        return root;
    }

}
