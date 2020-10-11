package patters.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] nums = {3,1};
		System.out.println(sol1(nums));
		
	}
	
	public static boolean sol1(int[] nums){
		Set<Integer> s = new HashSet();
		for(int i=0; i<nums.length; ++i) {
			if(!s.add(nums[i])) return true;
		}
		return false;
	}
}
