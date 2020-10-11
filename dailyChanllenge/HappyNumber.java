package dailyChanllenge;

import java.util.HashSet;

public class HappyNumber {
	public static void main(String[] args) {
		int n = 2;
		boolean res = true;
		HashSet<Integer> sumHash = new HashSet<Integer>();
		while(n!=1) {
			int sum =0;
			while(n!=0) {
				sum += (int)Math.pow(n%10, 2);
				n /= 10;
			}
			if(sumHash.contains(sum)) {
				res = false;
				break;
			}
			else {
				sumHash.add(sum);
				n =sum;
			}
		}
		System.out.println(res);
	}
}
