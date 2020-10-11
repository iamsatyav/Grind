package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSum15 {
	public static void main(String[] args) {
		int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		//threeSum(arr);
		add(5);
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
    	int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<n-1 && nums[i]<=0; ++i){
            HashMap<Integer, Integer> amap= new HashMap();
            if(i>0 && nums[i]!= nums[i-1]){
                HashSet<Integer> bset = new HashSet();
                for(int j=i+1; j<n; ++j){
                    if(!bset.contains(nums[j])){
                        if(amap.containsKey(-nums[j])){
                            bset.add(nums[j]);
                            res.add(Arrays.asList(nums[i], nums[j], amap.get(-nums[j])));
                        }else{
                            amap.put(nums[i]+nums[j], nums[j]);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    public static List<List<Integer>> threeSum2(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> res = new ArrayList<>();
    	for(int i=0; i<nums.length-2; ++i) {
    		int start = i+1, end = nums.length-1;
    		while(start<end) {
    			
    		}
    	}
    }
    
    public static void add(int a) {
    	loop: for(int i=1; i<3; ++i) {
    		for(int j=1; j<3; ++j) {
    			if(a==5) {
    				break loop;
    			}
    			System.out.println(i*j);
    		}
    	}
    }
    
    public static int barr(int[] arr, int m) {
    	int currOdds = 0;
    	int res = 0;
    	int[] memo = new int[arr.length];
    	for(int i=0; i<arr.length; ++i) {
    		if(memo[currOdds] >0) memo[currOdds]++;
    		else memo[currOdds] = 1;
    		
    		currOdds += arr[i]%2==0?0:1;
    		if(currOdds >= m)
    			res += memo[currOdds - m];
    	}
    	return res;
    }
}
