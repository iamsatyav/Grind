package medium.amazon;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSumCLosest {
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		System.out.println(threeSumClosest2(nums, 1));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2; ++i){
            int curr = helper(nums, i, target);
            if(Math.abs(target-curr) < Math.abs(target-res))
                res = curr;
        }
        return res;
    }
    
    public static int helper(int[] nums, int i, int target){
        int lo = i+1, hi=nums.length-1, currRes = nums[i] + nums[lo] + nums[hi];
        while(lo<hi){
            int currSum = nums[i] + nums[lo] + nums[hi];
            if(Math.abs(target-currSum) < Math.abs(target-currRes))
                currRes = currSum;
            if(currSum>target) hi--;
            else if(currSum<target) lo++;
            else return target;
        }
        return currRes;
    }
    
    public static int threeSumClosest2(int[] nums, int target) {
    	Arrays.sort(nums);
    	TreeSet<Integer> aset = new TreeSet<>();
    	for(int i=0; i<nums.length-2; ++i) {
    		int curr = helper(nums, i, target);
    		aset.add(curr);
    	}
    	return (Math.abs(aset.ceiling(target) - target) 
    			< Math.abs(aset.floor(target)-target))? aset.ceiling(target) : aset.floor(target);
    }
}
