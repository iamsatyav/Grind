package dailyChanllenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CountingElements {
	public static void main(String[] args) {
		int[] arr = {1,3,2,3,5,0};
		Arrays.sort(arr);
		int repCount = 1;
		int totCount = 0;
		
		for(int i=1; i<arr.length; ++i) {
			if(arr[i] == arr[i-1])
				repCount++;
			else if(arr[i] == arr[i-1]+1) {
				totCount += repCount;
				repCount = 1;
			}
			else
				repCount = 1;
		}
		System.out.println(totCount);
	}
}
