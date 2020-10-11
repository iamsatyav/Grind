package medium.amazon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class PrisonCells957 {
	public static void main(String[] args) {
		int[] cells = {1,0,0,1,0,0,1,0};
		int N = 1000000000;
		cells = prisonAfterNDays(cells, N);
		System.out.println(Arrays.toString(cells));
	}
	
	public static int[] prisonAfterNDays(int[] cells, int N) {
		LinkedHashSet<String> aset = new LinkedHashSet();
		aset.add(convertToString(cells));
		for(int i=1; i<N+1; ++i) {
			int[] updated = new int[8];
			updated[0] = 0;
			updated[cells.length-1] = 0;
			for(int j=1; j<cells.length-1; ++j) {
				if(cells[j-1]==cells[j+1])
					updated[j]=1;
				else
					updated[j]=0;
			}
			cells = updated;
			String curr = convertToString(cells);
			//Fast Forward check
			if(!aset.add(curr)) {
				Iterator<String> it = aset.iterator();
				int count = 0;
				while(it.hasNext()) {
					String temp = it.next();
					if(curr.equals(temp)) {
						int loopSize = aset.size() - count;
						int moreSteps = (N - count)%loopSize;
						while(moreSteps > 0) {
							temp = it.next();
							moreSteps--;
						}
						return convertBack(temp);
					}
					count++;
				}
			}
		}
		return cells; 
	}
	
	public static String convertToString(int[] arr) {
		String res = "";
		for(int i=0; i<arr.length;++i) {
			res += arr[i];
		}
		return res;
	}
	
	public static int[] convertBack(String s) {
		int[] res = new int[s.length()];
		for(int i=0; i<s.length(); ++i) {
			res[i] = Character.getNumericValue(s.charAt(i));
		}
		return res;
	}
	
}
