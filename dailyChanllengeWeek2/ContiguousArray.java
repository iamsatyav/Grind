package dailyChanllengeWeek2;

public class ContiguousArray {
	public static void main(String[] args) {
		int[] nums = {0,1,1,0,1,1,1,0};
		int c0=0, c1=0, res=0;
		for(int i=0;i<nums.length;++i) {
			if(nums[i]==0) {
				c0++;
				res = Math.max(res, 2*Math.min(c0, c1));
			}else if(nums[i]==1) {
				c1++;
				res = Math.max(res, 2*Math.min(c0, c1));
			}else {
				if(c0!=c1) {
					c0=0;c1=0;
				}
			}
		}
		System.out.println(res);
	}

}