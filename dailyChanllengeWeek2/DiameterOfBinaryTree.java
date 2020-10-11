package dailyChanllengeWeek2;

import java.util.ArrayList;

public class DiameterOfBinaryTree {
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){this.val = x;}
	}
	public static void main(String[] args) {
		
	}
	
	public static int diameterOfBinaryTree(TreeNode node) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(node.left == null && node.right == null) {
			res.add(0);
		}
		else if(node.left == null) {
			res.add(1+maxDepthFromNode(node.right));
		}
		else if(node.right == null) {
			res.add(1+maxDepthFromNode(node.left));
		}
		else {
			return 2 + maxDepthFromNode(node.left) + maxDepthFromNode(node.right);
		}
	}
	
	public static int diameterOfNode(TreeNode node) {
		if(node.left == null && node.right == null) {
			return 0;
		}
		else if(node.left == null) {
			return 1+maxDepthFromNode(node.right);
		}
		else if(node.right == null) {
			return 1+maxDepthFromNode(node.left);
		}
		else {
			return 2 + maxDepthFromNode(node.left) + maxDepthFromNode(node.right);
		}
	}
	
	public static int maxDepthFromNode(TreeNode node) {
		if(node.left == null && node.right == null) {
			return 0;
		}
		else if(node.left == null) {
			return 1+maxDepthFromNode(node.right);
		}
		else if(node.right == null) {
			return 1+maxDepthFromNode(node.left);
		}
		else
			return 1+Math.max(maxDepthFromNode(node.left), maxDepthFromNode(node.right));
	}
}
