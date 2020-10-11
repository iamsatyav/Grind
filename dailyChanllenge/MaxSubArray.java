package dailyChanllenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSubArray {
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int[] prevCurrMax = {Integer.MIN_VALUE, Integer.MIN_VALUE};
		for(int i=nums.length-1; i>=0; --i) {
			int[] M = new int[nums.length];
			boolean[] B = new boolean[nums.length];
			topDown(i, nums.length-1, M, B, nums, prevCurrMax);
			if(prevCurrMax[1]>prevCurrMax[0])
				prevCurrMax[0] = prevCurrMax[1];
			prevCurrMax[1] = Integer.MIN_VALUE;
		}
		System.out.println("Max Sub array sum is : "+ prevCurrMax[0]);
	}
	
	public static void topDown(int index, int currIndex, int[] M, boolean[] B, int[] nums,int[] prevCurrMax) {
		if(currIndex == index) {
			M[currIndex] = nums[currIndex];
			B[currIndex] = true;
			prevCurrMax[1] = nums[currIndex];
		}
		else {
			if(!B[currIndex-1])
				topDown(index, currIndex-1, M, B, nums, prevCurrMax);
			M[currIndex] = nums[currIndex] + M[currIndex-1];
			B[currIndex] = true;
			if(M[currIndex] > prevCurrMax[1])
				prevCurrMax[1] = M[currIndex];
		}
	}
}
