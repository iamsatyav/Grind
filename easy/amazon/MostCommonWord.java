package easy.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
	public static void main(String[] args) {
		System.out.println(mostCommonWord("Bob", new String[] {}));
		String s = "saas";
		s.substring(0).compareTo("as");
	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Set<Character> ignoreSet = new HashSet<>(Arrays.asList('!', '?', '\'',',',';','.',' '));
        HashMap<String, Integer> countMap = new HashMap<>();
        String currWord = "";
        String res = "";
        int maxCount = 0;
        for(int i=0;i<paragraph.length(); ++i){
            if(!ignoreSet.contains(paragraph.charAt(i)) && i!=paragraph.length()-1){
                currWord += paragraph.charAt(i);
            }else if(currWord.length()!=0){
            	if(i==paragraph.length()-1) currWord+=paragraph.charAt(i);
                currWord = currWord.toLowerCase();
                if(bannedSet.contains(currWord)) {
                	currWord="";
                	continue;
                }
                int count = countMap.getOrDefault(currWord, 0) + 1;
                countMap.put(currWord, count);
                if(count > maxCount){
                    maxCount = count;
                    res = currWord;
                }
                currWord = "";
            }
        }
		return res;
    }
}
