package easy.amazon;

import java.util.ArrayList;
import java.util.List;

import patterns.bfs.TreeNode;
import patterns.bfs._TreeService;

public class PathSum437 {
	static int count;
	static int targetSum;
	public static void main(String[] args) {
		TreeNode root = _TreeService.getPerfectBinaryTree();
		System.out.println(pathSum2(root, 7));
	}
	
    public static int pathSum(TreeNode root, int sum) {
        targetSum = sum;
        count = 0;
        helper(root, new ArrayList());
        return count;
    }
    
    public static void helper(TreeNode node, List<Integer> pathVals) {
    	if(node == null) return;
    	int s = node.val;
    	if(s==targetSum) count++;
    	for(int i=pathVals.size()-1; i>=0; --i) {
    		s += pathVals.get(i);
    		if(s == targetSum) count++;
    	}
    	List<Integer> newPathVals = new ArrayList(pathVals);
    	newPathVals.add(node.val);
    	helper(node.left, newPathVals);
    	helper(node.right, newPathVals);
    }
    
    public static int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }
    
    private static int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
