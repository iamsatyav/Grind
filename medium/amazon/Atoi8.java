package medium.amazon;

public class Atoi8 {
	public static void main(String[] args) {
		String s = " -1010023630o4";
		System.out.println(myAtoi(s));
	}
	
    public static int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        int start = 0;
        int sign = 1;
        if(str.charAt(start) == '-') {
        	sign = -1;
        	start++;
        }
        else if(str.charAt(start)=='+') {
        	start++;
        }else if(!Character.isDigit(str.charAt(start)))
        	return 0;
        while(start<str.length() && Character.isDigit(str.charAt(start))
        		&& str.charAt(start)-'0'==0) start++;
        if(start == str.length() || !Character.isDigit(str.charAt(start))) return 0;
        int curr = start;
        while(curr<str.length() && Character.isDigit(str.charAt(curr))) curr++;
        int maxDigits = (int) (1 + 31 * Math.log10(2));
        if(curr-start > 10) {
        	if(sign == 1) return Integer.MAX_VALUE;
        	else return Integer.MIN_VALUE;
        }else if(curr-start == 10) {
        	long num = Long.parseLong(str.substring(start, curr));
        	long maxInt = Integer.MAX_VALUE;
        	if(num > maxInt) {
        		if(sign == -1) return Integer.MIN_VALUE;
        		else return Integer.MAX_VALUE;
        	}else if(num==maxInt){
        		if(sign==-1) return Integer.MIN_VALUE+1;
        		else return Integer.MAX_VALUE;
        	}else {	
        		if(sign == -1) return sign*(int)num;
        		else return (int)num;
        	}
        }else {
        	return sign*Integer.parseInt(str.substring(start, curr));
        }
    }
}
