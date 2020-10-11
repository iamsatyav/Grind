package sean.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
	static List<List<Integer>> res = new ArrayList();
	public static void main(String[] args) {
		subsets(new int[] {1,2,3});
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
        helper(0, new ArrayList(), nums);
        System.out.println(Arrays.deepToString(res.toArray()));
        return res;
    }
    
    public static void helper(int i, List<Integer> currList, int[] nums){
        if(i==nums.length){
            res.add(currList);
            return;
        }
        List<Integer> addCurrList = new ArrayList<>(currList);
        addCurrList.add(nums[i]);
        helper(i+1, currList, nums);
        helper(i+1, addCurrList, nums);
    }
}
