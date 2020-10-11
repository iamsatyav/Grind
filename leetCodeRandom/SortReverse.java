package leetCodeRandom;

import java.util.Arrays;
import java.util.Comparator;

public class SortReverse {
	public static void main(String[] args) {
		Integer[] arr = {1,2,15,16,34,2,6,9,100,37};
//		Arrays.sort(arr, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer a, Integer b) {
//				return a>=b ? -1 : 1; 
//			}
//		});
		
		Arrays.sort(arr, (a, b) -> {
				return a>=b ? -1 : 1; 
		});
		System.out.println(Arrays.deepToString(arr));
	}
}
