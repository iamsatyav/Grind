package patters.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Find All Numbers Disappeared in an Array
public class Leet448 {
	public static void main(String[] args) {
		int[] nums = {3,1,4,4,3};
		int n = nums.length;
        Set<Integer> mset = new HashSet<Integer>();
        for(int i=1; i<=nums.length; ++i){
            mset.add(i);
        }
        for(int ea:nums) {
        	mset.remove(ea);
        }
        List<Integer> res = new ArrayList();
        for(int ea: mset){
            res.add(ea);
        }
        for(int ea:res) {
        	System.out.println(ea+" ");
        }
	}
}
