package easy.amazon;

import java.util.HashMap;

public class MostCommonWord819 {
	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		System.out.println(mostCommonWord(paragraph, banned));
	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> amap = new HashMap();
		for(String ea: banned) {
        	amap.put(ea, -1);
        }
		String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
		String res = "";
		int maxCount = 0;
		for(String ea: words) {
			int currCount = amap.getOrDefault(ea, 0)+1;
			if(currCount > 0) {
				amap.put(ea, currCount);
				if(currCount > maxCount) {
					maxCount = currCount;
					res = ea;
				}
			}
		}
		return res;
    }
}
