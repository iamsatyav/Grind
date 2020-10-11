package medium.amazon;

import java.util.HashMap;

public class LongestSubstringNoRepeat3 {
	public static void main(String[] args) {
		String s = "au";
		System.out.println(lengthOfLongestSubString2(s));
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	if(s.length() <= 1) return s.length();
        int pivot = 0;
        String res = "";
        HashMap<Character, Integer> amap = new HashMap();
        amap.put(s.charAt(0), 0);
        res += s.charAt(0);
        for(int i=1; i<s.length(); ++i) {
        	if(amap.containsKey(s.charAt(i))) {
        		pivot = amap.get(s.charAt(i)) + 1;
        		amap = new HashMap();
        		for(int j=pivot; j<= i; ++j) {
        			amap.put(s.charAt(j), j);
        		}
        	}
        	else {
        		String temp = s.substring(pivot, i+1);
        		if(temp.length() > res.length())
        			res = temp;
        		amap.put(s.charAt(i), i);
        	}
        }
        return res.length();
    }
    
    public static int lengthOfLongestSubString2(String s) {
    	if(s.length() <= 1) return s.length();
    	String res = ""+s.charAt(0);
    	int pivot = 0;
    	for(int i=1; i<s.length(); ++i) {
    		int currCharIndex = s.indexOf(s.charAt(i), pivot);
    		if(currCharIndex >= i) currCharIndex = -1;
    		if(currCharIndex != -1) {
    			if(res.length() < i-pivot) res = s.substring(pivot, i);
    			pivot = currCharIndex+1;
    		}else if(i==s.length()-1) {
    			if(res.length() < i-pivot+1) res = s.substring(pivot, i+1);
    		}
    	}
    	return res.length();
    }
    
    public int lengthOfLongestSubstring3(String s) {
        int i=0, j=0, res = 0;
        HashMap<Character, Integer> amap = new HashMap();
        while(j<s.length()){
            if(amap.containsKey(s.charAt(j)) && amap.get(s.charAt(j)) >=i){
                i = Math.max(amap.get(s.charAt(j))+1, i);
            }else{
                res = Math.max(res, j-i+1);
            }
            amap.put(s.charAt(j), j);
            j++;
        }
        return res;
    }
    
    
}
