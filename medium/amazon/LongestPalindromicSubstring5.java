package medium.amazon;

public class LongestPalindromicSubstring5 {
	static boolean[][] memoCache;
	public static void main(String[] args) {
		String inp = "ccc";
		System.out.println(longestPalindrome(inp));
		
	}
	
	public static String longestPalindrome(String s) {
		String res = "";
		for(double i=0; i<=s.length()-1; i=i+0.5) {
			if(res.length() > 2*Math.min(i-0, s.length()-i))
				break;
			for(int a = (int) Math.floor(i), b = (int) Math.ceil(i); a>=0 && b<=s.length()-1; --a, ++b) {
				if(s.charAt(a) != s.charAt(b)) {
					break;
				}else {
					if(res.length() < s.substring(a, b+1).length()) {
						res = s.substring(a, b+1);
					}
				}
			}
		}
		return res;
	}
	
	
	public static String longestPalindromeBruteDP(String s) {
		if(s.length() == 0 || s.length() == 1) return s;
		memoCache = new boolean[s.length()][s.length()];
		for(int i=0; i<s.length();++i) {
			memoCache[i][i] = true;
		}
        for(int i=s.length(); i>1; --i) {
        	for(int j=i; j<=s.length(); ++j) {
        		if(!memoCache[j-1][j-i]) {
        			if(isPalindromeBruteDP(s.substring(j-i, j), j-i)) return s.substring(j-i, j);
        		}
        		else if(memoCache[j-i][j-1])
        			return s.substring(j-i, j);
        		
        	}
        }
        return Character.toString(s.charAt(0));
    }
	
	public static boolean isPalindromeBruteDP(String s, int pre) {
		for(int i=s.length()/2-1; i>=0; --i) {
			if(s.charAt(i) != s.charAt(s.length()-i-1)) {
				memoCache[pre+i][pre+s.length()-i-1] = false;
				memoCache[pre+s.length()-i-1][pre+i] = true;
				return false;
			}else {
				if(memoCache[pre+i+1][pre+s.length()-i-2]) {
					memoCache[pre+i][pre+s.length()-i-1] = true;
					memoCache[pre+s.length()-i-1][pre+i] = true;
				}
			}
		}
		return true;
	}
}
