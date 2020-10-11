package dailyChanllenge;

import java.util.Arrays;

public class BuyAndSellStock2 {
	public static void main(String[] args) {
		int[] nums = {7,1,5,3,6,4};
		int[] nums2 = new int[nums.length-1];
		for(int i=0; i<nums.length-1; ++i) {
			nums2[i] = nums[i]-nums[i+1];
		}
		System.out.println(Arrays.toString(nums2));
	}
}
