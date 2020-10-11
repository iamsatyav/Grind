package easy.amazon;

import java.util.HashMap;

public class RomanToInteger {
	public static void main(String[] args) {
		System.out.println(romanToInt2("IV"));
	}
	
    public static int romanToInt(String s) {
    	HashMap<Character, Integer> amap = new HashMap<>();
    	amap.put('I', 1);
    	amap.put('V', 5);
    	amap.put('X', 10);
    	amap.put('L', 50);
    	amap.put('C', 100);
    	amap.put('D', 500);
    	amap.put('M', 1000);
    	int res = 0;
    	if(s.length()==1) return amap.get(s.charAt(0));
        for(int i=1; i<s.length(); ++i) {
        	if(amap.get(s.charAt(i)) > amap.get(s.charAt(i-1))) {
        		res += amap.get(s.charAt(i)) - amap.get(s.charAt(i-1));
        		i++;
        		if(i==s.length()-1)
        			res += amap.get(s.charAt(s.length()-1));
        	}else {
        		res += amap.get(s.charAt(i-1));
        		if(i==s.length()-1)
        			res += amap.get(s.charAt(s.length()-1));
        	}
        }
        
        return res;
    }
    
    public static int romanToInt2(String s) {
    	HashMap<Character, Integer> amap = new HashMap<>();
    	amap.put('I', 1);
    	amap.put('V', 5);
    	amap.put('X', 10);
    	amap.put('L', 50);
    	amap.put('C', 100);
    	amap.put('D', 500);
    	amap.put('M', 1000);
    	int res = 0;
    	res += amap.get(s.charAt(0));
    	for(int i=1; i<s.length(); ++i) {
    		int curr = amap.get(s.charAt(i));
    		int prev = amap.get(s.charAt(i-1));
    		if(curr>prev) 
    			res += curr - 2*prev;
    		else
    			res += curr;
    	}
    	return res;
    }
}
