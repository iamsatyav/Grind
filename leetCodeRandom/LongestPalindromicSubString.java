package leetCodeRandom;

public class LongestPalindromicSubString {
	public static void main(String[] args) {
		String s = "c";
		System.out.println(mySolution(s));
	}
	
	public static String mySolution(String s) {
		for(int i=s.length(); i>0; i--) {
			int start = 0;
			int end = i;
			while(end<=s.length()) {
				if(isPalindrome(s.substring(start, end)))
					return s.substring(start, end);
				start++; end++;
			}
		}
		return "";
	}
	
//	public static String mySolution(String s) {
//		if(isPalindrome(s))
//			return s;
//		String thirdTemp = "";
//		boolean third = false;
//		for(int i=1;i<s.length(); ++i) {
//			boolean first = isPalindrome(s.substring(0, s.length()-i));
//			boolean second = isPalindrome(s.substring(i));
//			if(!third && i < s.length()/2) {
//				third = isPalindrome(s.substring(i, s.length()-i));
//				if(third)
//					thirdTemp = s.substring(i, s.length()-i);
//			}
//			
//			if(first)
//				return s.substring(0, s.length()-i);
//			else if(second)
//				return s.substring(i);
//			if(!thirdTemp.isEmpty() && (s.length()-i <= thirdTemp.length())) 
//				return thirdTemp;
//		}
//		return null;
//	}
	
	public static boolean isPalindrome(String s) {
		for(int i=0; i<s.length()/2;++i) {
			if(s.charAt(i) != s.charAt(s.length()-i-1))
				return false;
		}
		return true;
	}
}
