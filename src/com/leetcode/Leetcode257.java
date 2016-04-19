package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Leetcode257 {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode257 lc = new Leetcode257();
		TreeNode root = lc.new TreeNode(1);
		root.left = lc.new TreeNode(2);
//		root.right = lc.new TreeNode(3);
//		root.left.right = lc.new TreeNode(5);
		List<String> allPath = lc.binaryTreePaths(root);
		for (String path : allPath) {
			System.out.println(path);
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> allPath = new ArrayList<String>();
		Stack<TreeNode> path = new Stack<TreeNode>();
		if (root == null) return allPath;
		TreeNode prePop = root;
		path.push(root);
		while (!path.isEmpty()) {
			TreeNode node = path.peek();
			if (prePop == node.left) {
				if (node.right != null) {
					path.push(node.right);
				} else {
					prePop = path.pop();
				}
			} else if (prePop == node.right) {
				prePop = path.pop();
			} else {
				while (node.left != null) {
					node = node.left;
					path.push(node);
				} 
					
				if (node.right == null) {
					String tr = "";
					boolean isFirst = true;
					for (TreeNode item : path) {
						if (isFirst) {
							tr += item.val;
							isFirst = false;
						} else {
							tr += "->" + item.val;
						}
					}
					allPath.add(tr);
					prePop = path.pop();
				} else {
					path.push(node.right);
				}
			}
		}
		return allPath;
    }
}
