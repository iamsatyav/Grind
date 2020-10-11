package medium.amazon;

public class ProductOfArrayExceptSelf238 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		productExceptSelf(nums);
		
	}
	
	public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i=1; i<nums.length; ++i) {
        	left[i] = nums[i-1] * left[i-1];
        }
        int right = 1;
        for(int i=nums.length-1; i>=0; --i) {
        	left[i] *= right;
        	right *= nums[i];
        }
        return left;
    }
}
