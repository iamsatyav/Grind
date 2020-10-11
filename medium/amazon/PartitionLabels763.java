package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels763 {
	public static void main(String[] args) {
		String s = "eaaaabaaec";
		for(Integer ea: partitions(s)) {
			System.out.println(ea + ", ");
		}
	}
	
	public static List<Integer> partitions(String S){
		LinkedHashMap<Character, List<Integer>> amap = new LinkedHashMap();
		List<Integer> res = new ArrayList();
		for(int i=0; i<S.length(); ++i) {
			List<Integer> currList = amap.get(S.charAt(i));
			currList = (currList == null) ? new ArrayList() : currList;
			currList.add(i);
			amap.put(S.charAt(i), currList);
		}
		
		int x=0,y=0;
		while(y < S.length()) {
			Iterator<Map.Entry<Character, List<Integer>>> it = amap.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry<Character, List<Integer>> curr = it.next();
				if(x == y) {
					x = curr.getValue().get(0);
					y = curr.getValue().get(curr.getValue().size()-1);
					it.remove();
					if(x==y) break;
				}else {
					if(curr.getValue().get(0) < y) {
						if(curr.getValue().get(curr.getValue().size()-1) > y)
							y = curr.getValue().get(curr.getValue().size()-1);
						it.remove();
					}
					else
						break;
				}
			}
			res.add(y - x + 1);
			x = y +1;
			y = x;
		}
		return res;
	}
}
