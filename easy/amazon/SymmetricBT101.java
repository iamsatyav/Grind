package easy.amazon;

import patterns.bfs.TreeNode;
import patterns.bfs._TreeService;

public class SymmetricBT101 {
	public static void main(String[] args) {
		TreeNode root = _TreeService.getSymmetricBinaryTree();
		System.out.println(isSymmetric(root));
	}
	
    public static boolean isSymmetric(TreeNode root) {
    	if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    public static boolean helper(TreeNode n1, TreeNode n2) {
    	if(n1 == null && n2 == null) return true;
    	else if(n1 == null || n2 == null) return false;
    	else {
    		return n1.val == n2.val && helper(n1.left, n2.right) && helper(n1.right, n2.left);
    	}
    }
}
