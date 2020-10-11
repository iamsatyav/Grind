package dailyChanllengeWeek2;

public class PerformStringShifts {
	public static void main(String[] args) {
		int[][] shift = {{0,1}, {1,2}};
		String s = "abc";
		int left=0, right=0;
		for(int[] ea: shift) {
			if(ea[0] == 0) {
				left+=ea[1];
			}else {
				right+=ea[1];
			}
		}
		String res=s;
		int amount = Math.abs(left-right);
		amount = amount%s.length();
		if(left>right) {
			res = s.substring(amount, s.length()) + s.substring(0, amount);
		}else {
			res = s.substring(s.length() - amount, s.length()) + s.substring(0, s.length()-amount);
		}
		System.out.println(res);
	}
}
