package patterns.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BottomUpLevelOrder {
	public static void main(String[] args) {
		TreeNode root = _TreeService.getPerfectBinaryTree();
		List<List<Integer>> res = getBottomUpLevelOrder(root);
		System.out.println("res");
	}
	
	public static List<List<Integer>> getBottomUpLevelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList();
		helper(root, 0, res);
		Collections.reverse(res);
		return res;
    }
    
    public static void helper(TreeNode node, int height, List<List<Integer>> res){
        if(node == null)
            return;
        if(res.isEmpty() || res.size()< height+1)
        	res.add(new ArrayList());
        helper(node.left, height+1, res);
        helper(node.right, height+1, res);
        res.get(height).add(node.val);
    }
}
