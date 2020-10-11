package dailyChanllenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public static void main(String[] args) {
		Map<String, List<String>> myMap = new HashMap<String, List<String>>();
		List<List<String>> res = new ArrayList<List<String>>();
		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		for(int i=0; i<arr.length; ++i) {
			char[] temp = arr[i].toCharArray();
			Arrays.sort(temp);
			List<String> t = myMap.get(new String(temp));
			if(t == null) {
				t = new ArrayList<String>();
				t.add(arr[i]);
				myMap.put(new String(temp), t);
			}else {
				t.add(arr[i]);
				myMap.put(new String(temp),t);
			}
		}
		for(List<String> ea: myMap.values()) {
			System.out.println(Arrays.deepToString(ea.toArray()));
		}
	}
}
