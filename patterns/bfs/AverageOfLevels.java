package patterns.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Tuple{
    TreeNode node;
    int level;
    public Tuple(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

public class AverageOfLevels {
	public static void main(String[] args) {
		Deque<Tuple> mq = new LinkedList<Tuple>();
		TreeNode root = _TreeService.getPerfectBinaryTree();
		mq.add(new Tuple(root, 0));
		double currSum = 0, currCount = 0;
		int currLevel = 0;
		List<Double> res = new ArrayList();
		while(!mq.isEmpty()) {
			Tuple curr = mq.remove();
			if(curr.level == currLevel) {
				currSum += curr.node.val;
				currCount += 1;
			}else {
				res.add(currSum/currCount);
				currCount = 1;
				currSum = curr.node.val;
				currLevel = curr.level;
			}
			if(curr.node.left != null)
				mq.add(new Tuple(curr.node.left, curr.level+1));
			if(curr.node.right != null)
				mq.add(new Tuple(curr.node.right, curr.level+1));
		}
		res.add(currSum/currCount);
		for(Double ea: res) {
			System.out.println(ea+" ");
		}
	}
}
