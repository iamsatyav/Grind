package dailyChanllenge;

import java.util.Arrays;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,0};
		foo1(nums);
	}
	
	public static void foo1(int[] nums) {
		int nextInt = 0;
		for(int i=0; i<nums.length; ++i) {
			if(nums[i] == 0) {
				nextInt = nextInt==0? i+1:nextInt;
				while(nextInt<nums.length && nums[nextInt] ==0) {
					nextInt++;
				}
				if(nextInt < nums.length) {
					int temp = nums[nextInt];
					nums[nextInt++] = nums[i];
					nums[i] = temp;
				}else
					break;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
