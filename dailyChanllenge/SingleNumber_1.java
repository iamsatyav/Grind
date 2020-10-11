package dailyChanllenge;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_1 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,3,4,1,4,5,6,5,6};
		netSolution(nums);
	}
	
	public static void mySolution(int[] nums) {
		Set<Integer> x = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) { 
			if(x.contains(nums[i]))
				x.remove(nums[i]);
			else
				x.add(nums[i]);
		}
		System.out.println(x.toArray()[0]);
	}
	
	public static void netSolution(int[] nums) {
		int sum =0 ;
		for(int ea:nums) {
			sum^=ea;
		}
		System.out.println(sum);
	}
}


