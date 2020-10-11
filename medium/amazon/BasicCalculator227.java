package medium.amazon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class CalcNode {
	int code;
	int index;
	public CalcNode(int code, int index) {
		super();
		this.code = code;
		this.index = index;
	}
	
}

public class BasicCalculator227 {
	public static void main(String[] args) {
		String s = " 3+5 / 2 ";
		System.out.println(calculate(s));
	}
	
    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList();
        char sign = '+';
        int currVal = 0;
        for(int i=0; i<s.length(); ++i) {
        	if(Character.isDigit(s.charAt(i))) {
        		currVal = currVal*10 + (s.charAt(i) - '0');
        	}
        	if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i==s.length()-1) {
        		if(sign=='+') {
        			stack.push(currVal);
        		}else if(sign == '-') {
        			stack.push(-currVal);
        		}else if(sign=='/') {
        			stack.push(stack.pop()/currVal);
        		}else if(sign=='*') {
        			stack.push(stack.pop()*currVal);
        		}
        		sign = s.charAt(i);
        		currVal = 0;
        	}
        }
        
        int res = 0;
        while(!stack.isEmpty()) {
        	res += stack.pop();
        }
        return res;
    }
}
