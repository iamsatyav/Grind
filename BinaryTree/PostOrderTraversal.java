package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class PostOrderTraversal {
	public static void main(String[] args) {
		
	}
	
	public static List<Integer> postOrder(TreeNode node){
		Deque<TreeNode> stack = new LinkedList();
		stack.add(node);
		List<Integer> res = new ArrayList();
		while(!stack.isEmpty()) {
			
		}
	}
}
