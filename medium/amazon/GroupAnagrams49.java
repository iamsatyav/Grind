package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
	public static void main(String[] args) {
		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(arr);
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Integer>, List<String>> amap = new HashMap<>();
        List<Integer> currKeyTemplate = new ArrayList<>();
    	for(int j=0; j<26; j++) {
    		currKeyTemplate.add(0);
    	}
        for(int i=0; i<strs.length; ++i) {
        	String curr = strs[i];
        	List<Integer> currKey = new ArrayList<>(currKeyTemplate);
        	for(int k=0; k<curr.length();++k) {
        		int charIndex = curr.charAt(k)-'a';
        		currKey.set(charIndex, currKey.get(charIndex)+1);
        	}
        	if(amap.get(currKey) == null)
        		amap.put(currKey, new ArrayList());
        	amap.get(currKey).add(curr);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<List<Integer>, List<String>> ea: amap.entrySet()) {
        	res.add(ea.getValue());
        }
        return res;
    }
}
