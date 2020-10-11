package easy.amazon;

import java.util.HashMap;

public class TwoSum1 {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(nums, target);
		System.out.println(res[0]+" "+res[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> amap= new HashMap();
        for(int i=0; i<nums.length; ++i){
            if(amap.containsKey(target-nums[i]))
            	return new int[] {amap.get(target-nums[i]), i};
            amap.put(nums[i], i);
        }
        return null;
    }
}
