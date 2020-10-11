package easy.amazon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class FirstNode {
	int index;
	int count;
	public FirstNode(int index, int count) {
		super();
		this.index = index;
		this.count = count;
	}	
}

public class FirstUniqueChar387 {
	
	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
	
    public static int firstUniqChar(String s) {
        Map<Character, FirstNode> amap = new LinkedHashMap();
        for(int i=0; i<s.length(); ++i){
        	FirstNode curr = amap.getOrDefault(s.charAt(i), new FirstNode(i, 0));
        	curr.count++;
            amap.put(s.charAt(i), curr);
        }
        for(Entry<Character, FirstNode> ea: amap.entrySet()) {
        	if(ea.getValue().count == 1) return ea.getValue().index;
        }
        return -1;
    }
}
