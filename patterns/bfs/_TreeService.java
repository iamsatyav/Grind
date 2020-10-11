package patterns.bfs;

import patterns.bfs.TreeNode;

public class _TreeService {
	public static TreeNode getPerfectBinaryTree() {
		TreeNode b1 = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		TreeNode b3 = new TreeNode(3);
		TreeNode b4 = new TreeNode(4);
		TreeNode b5 = new TreeNode(5);
		TreeNode b6 = new TreeNode(6);
		TreeNode b7 = new TreeNode(7);
		TreeNode b8 = new TreeNode(8);
		TreeNode b9 = new TreeNode(9);
		TreeNode b10 = new TreeNode(10);
		TreeNode b11 = new TreeNode(11);
		TreeNode b12 = new TreeNode(12);
		TreeNode b13 = new TreeNode(13);
		TreeNode b14 = new TreeNode(14);
		TreeNode b15 = new TreeNode(15);
		
		b1.left = b2;
		b1.right = b3;
		b2.left = b4;
		b2.right = b5;
		b3.left = b6;
		b3.right = b7;
		b4.left = b8;
		b4.right = b9;
		b5.left = b10;
		b5.right = b11;
		b6.left = b12;
		b6.right = b13;
		b7.left = b14;
		b7.right = b15;
		return b1;
	}
	
	public static TreeNode getSymmetricBinaryTree() {
		TreeNode b1 = new TreeNode(1);
		TreeNode b2 = new TreeNode(2);
		TreeNode b3 = new TreeNode(2);
		TreeNode b4 = new TreeNode(3);
		TreeNode b5 = new TreeNode(3);
		TreeNode b6 = new TreeNode(5);
		TreeNode b7 = new TreeNode(5);
		TreeNode b8 = new TreeNode(6);
		TreeNode b9 = new TreeNode(6);
		
		b1.left = b2;
		b1.right = b3;
		b2.left = b4;
		b2.right = b6;
		b3.left = b7;
		b3.right = b5;
		b6.left = b8;
		b7.right = b9;
		return b1;
	}
}
