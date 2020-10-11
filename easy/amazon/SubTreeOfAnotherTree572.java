package easy.amazon;

import java.util.Deque;
import java.util.LinkedList;

import patterns.bfs.TreeNode;
import patterns.bfs._TreeService;

public class SubTreeOfAnotherTree572 {
	public static void main(String[] args) {
		TreeNode root1 = _TreeService.getPerfectBinaryTree();
		TreeNode root2 = _TreeService.getPerfectBinaryTree();
		root2 = root2.right;
		System.out.println(isSubtree(root1, root2));
	}
	
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        Deque<TreeNode> aq = new LinkedList();
        aq.add(s);
        while(!aq.isEmpty()) {
        	TreeNode curr = aq.poll();
        	if(curr.val == t.val && similarTrees(curr, t)) return true;
        	if(curr.left != null) aq.add(curr.left);
        	if(curr.right != null) aq.add(curr.right);
        }
        return false;
    }
	
	public static boolean similarTrees(TreeNode s, TreeNode t) {
		if(s==null && t==null) return true;
		if((s==null && t!=null) || (s!=null && t==null)) return false;
		return (s.val == t.val && similarTrees(s.left, t.left) 
				&& similarTrees(s.right, t.right)) ? true : false;
	}
}
