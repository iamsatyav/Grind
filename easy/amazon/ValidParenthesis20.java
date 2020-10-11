package easy.amazon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * ( : -8
) : -7
{ : 75
} : 77
[ : 43
] : 45
*/
public class ValidParenthesis20 {
	public static void main(String[] args) {
		String s = "([)]";
		System.out.println(isValid(s));
	}
	
    public static boolean isValidBrute(String s) {
        Deque<Character> s1 = new LinkedList();
        Deque<Character> s2 = new LinkedList();
        HashMap<Character, Character> amap= new HashMap();
        amap.put('(', ')');
        amap.put('{', '}');
        amap.put('[', ']');
        for(int i=0; i<s.length(); ++i) {
        	s1.push(s.charAt(i));
        }
        
        while(!s1.isEmpty()) {
        	char curr = s1.pop();
        	if(s2.size()>0 && s2.peek() == amap.get(curr))
        		s2.pop();
        	else
        		s2.push(curr);
        	if(s1.size() < s2.size())
        		return false;
        }
        return true;
    }
    
    public static boolean isValidIncorrect(String s) {
    	HashMap<Character, List<Integer>> amap= new HashMap();
        amap.put('(', new ArrayList());
        amap.put('{', new ArrayList());
        amap.put('[', new ArrayList());
        amap.put(')', new ArrayList());
        amap.put('}', new ArrayList());
        amap.put(']', new ArrayList());
    	for(int i=0; i<s.length(); ++i) {
    		amap.get(s.charAt(i)).add(i);
    	}
    	if(amap.get('(').size() != amap.get(')').size() ||
    		amap.get('[').size() != amap.get(']').size() ||
    			amap.get('{').size() != amap.get('}').size()) return false;
    	
    	HashMap<Character, Character> mirror= new HashMap();
        mirror.put('(', ')');
        mirror.put('{', '}');
        mirror.put('[', ']');
        
        for(Entry<Character, Character> ea: mirror.entrySet()) {
        	if(amap.get(ea.getKey()).size()>0) {
        		for(int i=0; i<amap.get(ea.getKey()).size(); ++i) {
        			int diff = amap.get(ea.getKey()).get(i) - amap.get(ea.getValue())
            				.get(amap.get(ea.getValue()).size()-i-1);
            		if(Math.abs(diff) != 1 && Math.abs(diff)%2 != 0)
            			return false;
            	}
        	}
        }
    	return true;
    }
    
    public static boolean isValid(String s) {
    	if(s.length() == 0) return true;
    	Deque<Character> stack = new LinkedList();
    	HashMap<Character, Character> mirror= new HashMap();
        mirror.put('(', ')');
        mirror.put('{', '}');
        mirror.put('[', ']');
    	int indx = 0;
    	stack.push(s.charAt(indx++));
    	while(indx<s.length()) {
    		if(mirror.getOrDefault(stack.peek(), 'a') == s.charAt(indx))
    			stack.pop();
    		else
    			stack.push(s.charAt(indx));
    		indx++;
    	}
    	return stack.isEmpty();
    }
    
}
