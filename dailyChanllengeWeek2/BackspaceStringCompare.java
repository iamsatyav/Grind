package dailyChanllengeWeek2;

public class BackspaceStringCompare {
	public static void main(String[] args) {
		String S = "bxj##tw", T = "bxo#j##tw";
		boolean res = backSpaceCompare(S, T);
		
	}
	
	/*
	 * public static int getCorrectedHash(String S) { int BASE = 10, sHash = 0,
	 * validIndex = 0; for(int i=0; i<S.length();++i) { if(S.charAt(i)!= '#') {
	 * sHash = BASE*(sHash); sHash += S.charAt(i); } else { int k=1;
	 * while(i<S.length() && S.charAt(i)=='#') { if(sHash != 0) { sHash = sHash -
	 * S.charAt(i-k); sHash = sHash/BASE; k += 2; } i++; } i--; } } return sHash; }
	 */
	
	public static boolean backSpaceCompare(String S, String T) {
		int sLen = S.length()-1, tLen = T.length()-1;
		int sSkip =0, tSkip=0;
		while(sLen >=0 || tLen >=0) {
			while(sLen >= 0) {
				if(S.charAt(sLen)=='#') {sSkip++; sLen--;}
				else if(sSkip>0) {sSkip--; sLen--;}
				else break;
			}
			
			while(tLen >=0) {
				if(T.charAt(tLen)=='#') {tSkip++; tLen--;}
				else if(tSkip>0) {tSkip--; tLen--;}
				else break;
			}
			
			if(sLen >=0 && tLen>=0)
				if(S.charAt(sLen) != T.charAt(tLen)) return false;
			if(sLen >=0 != tLen >=0)
				return false;
			sLen--; tLen--;
		}
		return true;
	}
}
