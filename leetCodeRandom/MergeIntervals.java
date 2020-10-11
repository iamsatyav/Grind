package leetCodeRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,3}, {2,5}, {7,9},{10,14}};
		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(arr, (a, b)-> Integer.compare(a[1],b[1]));
		for(int i=0; i<arr.length-1; ++i) {
			if(arr[i][1] >= arr[i+1][0]) {
				arr[i+1][0] = arr[i][0];
				arr[i+1][1] = arr[i+1][1];
				arr[i] = new int[] {-1,-1};
			}
		}
		
		for(int i=0; i<arr.length; ++i) {
			if(arr[i][0] > -1) {
				res.add(new ArrayList<Integer>(Arrays.asList(arr[i][0], arr[i][1])));
			}
		}
		
		res.toArray();
	}
}
