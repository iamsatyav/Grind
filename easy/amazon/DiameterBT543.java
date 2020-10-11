package easy.amazon;

import patterns.bfs.TreeNode;
import patterns.bfs._TreeService;

public class DiameterBT543 {
	static int maxDia;
	public static void main(String[] args) {
		TreeNode root = _TreeService.getPerfectBinaryTree();
		maxDia = 0;
		System.out.println(diameterOfBinaryTree(root));
	}
	
	public static int diameterOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
        helper(root);
        return maxDia;
    }
	
	public static int helper(TreeNode node) {
		int left = (node.left != null) ? helper(node.left)+1 : 0;
		int right = (node.right != null)? helper(node.right)+1 : 0;
		int dia = left + right;
		if(dia > maxDia)
			maxDia = left+right;
		return Math.max(left, right);
	}
	
}
