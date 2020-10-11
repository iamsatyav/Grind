package patterns.bfs;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepth {
	public static void main(String[] args) {
		TreeNode root = _TreeService.getPerfectBinaryTree();
		Deque<TreeNode> qwe = new LinkedList<TreeNode>();
		qwe.add(root);
		int level =0;
		while(!qwe.isEmpty()) {
			level++;
			int qSize = qwe.size();
			for(int i=0; i<qSize; ++i) {
				TreeNode node = qwe.poll();
				if(node.left == null && node.right==null) {
					System.out.println("Minimum depth : "+ level);
					return;
				}
				if(node.left != null)
					qwe.add(node.left);
				if(node.right != null)
					qwe.add(node.right);
			}
		}
	}
}
