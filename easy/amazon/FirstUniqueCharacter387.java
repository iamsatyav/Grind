package easy.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacter387 {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
		Set<Character> aset = new HashSet<>(Arrays.asList('a', 'b', 'a'));
		String s = "LEEtcode";
		System.out.println();
	}
	
	public static int firstUniqChar(String s) {
        if(s.length()==0) return -1;
        Map<Character, Integer> charIndex = new LinkedHashMap<>();
        for(int i=0; i<s.length(); ++i){
            if(charIndex.containsKey(s.charAt(i)))
                charIndex.put(s.charAt(i), -1);
            else
                charIndex.put(s.charAt(i), i);
        }
        for(Map.Entry<Character, Integer> entry: charIndex.entrySet()){
            if(entry.getValue() != 1) return entry.getValue();
        }
        return -1;
    }
}
