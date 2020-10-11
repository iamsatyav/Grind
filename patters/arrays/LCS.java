package patters.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LCS {
	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		longestConsecutive(nums);
	}
	
	public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> mapNext = new HashSet<Integer>();
        int res = 1;
        for(int i=0; i<n; ++i){
            map.put(nums[i], null);
        }
        //null - no prev & next exist
        //0 - both prev and next exists
        //-1 - only prev exists
        //1 only next exists
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()) {
        	Integer ea = it.next();
        	if(map.containsKey(ea+1) && map.containsKey(ea-1))
        		map.put(ea, 0);
        	else if(map.containsKey(ea+1)) {
        		mapNext.add(ea);
        	}
        	else if(map.containsKey(ea-1)) {
        		map.put(ea, -1);
        	}
        	else
        		it.remove();
        }
        
        for(Integer ea: mapNext) {
    		int currCount = 1;
    		Integer curr = ea;
        	while(map.get(curr+1)!=-1) {
        		curr = curr+1;
        		currCount++;
        	}
        	currCount++;
        	if(res<currCount)
        		res = currCount;
        }
        return res;
    }
}
