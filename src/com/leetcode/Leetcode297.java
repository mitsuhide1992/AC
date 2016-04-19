package com.leetcode;

import java.util.Stack;

public class Leetcode297 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode297 lc = new Leetcode297();
		TreeNode root = lc.new TreeNode(1);
        root.left = lc.new TreeNode(2);
//        root.right = lc.new TreeNode(3);
//        root.left.left = lc.new TreeNode(4);
//        root.left.right = lc.new TreeNode(5);
//        root.right.left = lc.new TreeNode(6);
//        root.right.right = lc.new TreeNode(7);
        String data = lc.serialize(root);
        System.out.println(data);
        TreeNode reroot = lc.deserialize(data);
        lc.firstRoot(reroot, 0);
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return firstRoot(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data.equals("")) return null;
        String [] fs = data.split(",");
        Stack<TreeNode> space = new Stack<TreeNode>();
        int state = 0;
        TreeNode root = null;
        for (int i = 0; i < fs.length; i++) {
        	TreeNode node = null;
        	if (state == 0) {
        		if (!fs[i].equals("#")) {
        			node = new TreeNode(Integer.parseInt(fs[i]));
        			if (!space.isEmpty()) {
        				TreeNode lastNode = space.peek();
        				lastNode.left = node;
        			}
        			space.push(node);
        		} else {
					state = 1;
				}
        	} else if (state == 1) {
        		if (!fs[i].equals("#")) {
        			node = new TreeNode(Integer.parseInt(fs[i]));
        			if (!space.isEmpty()) {
        				TreeNode lastNode = space.peek();
        				lastNode.right = node;
        			}
        			state = 0;
        			space.push(node);
        		} else {
        			TreeNode lastNode = space.pop();
        			while (!space.isEmpty() && space.peek().right == lastNode) {
        				lastNode = space.pop();
        			}
				}
        	}
        	if (root == null) root = node;
        }
        return root;
    }
    
    public String firstRoot(TreeNode root) {
        if (root == null) return "";
        StringBuffer sb = new StringBuffer("");
        Stack<TreeNode> space = new Stack<TreeNode>();
        space.push(root);
        while (!space.isEmpty()) {
        	TreeNode node = space.pop();
        	if (node.val != Integer.MIN_VALUE) {
        		sb.append(sb.length() == 0 ? node.val : "," + node.val);
        		if (node.right != null) {
                	space.push(node.right);
                } else {
                	space.push(new TreeNode(Integer.MIN_VALUE));
                }
                
                if (node.left != null) {
                	space.push(node.left);
                } else {
                	space.push(new TreeNode(Integer.MIN_VALUE));
                }
        	} else {
        		sb.append(sb.length() == 0 ? "#" : ",#");
        	}
        }
        return sb.toString();
    }
    
    public void firstRoot(TreeNode root, int sign) {
        if (root == null) return;
        Stack<TreeNode> space = new Stack<TreeNode>();
        space.push(root);
        while (!space.isEmpty()) {
        	TreeNode node = space.pop();
            System.out.println(node.val);
            if (node.right != null) space.push(node.right);
            if (node.left != null) space.push(node.left);
        }
    }
    
}
