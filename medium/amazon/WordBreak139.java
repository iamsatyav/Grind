package medium.amazon;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordBreakNode {
	char val;
	Map<Character, WordBreakNode> nextMap;
	boolean isWord;
	public WordBreakNode(char val) {
		super();
		this.val = val;
		this.nextMap = new HashMap();
		this.isWord = false;
	}
	
}

public class WordBreak139 {
	static List<String> wordDictSt;
	public static void main(String[] args) {
		String s = "bb";
		List<String> wordDict = Arrays.asList("a", "b", "bbb", "bbbb");
		System.out.println(wordBreakBST(s, wordDict));
	}
	
	public static boolean wordBreakMemo(String s, List<String> wordDict) {
        if (s.length()==0) return false;
        wordDictSt = wordDict;
        Map<String, Boolean> memoMap = new HashMap();
        return helperMemo(s, memoMap);
    }
	
	public static boolean helperMemo(String sub, Map<String, Boolean> memoMap) {
		if(sub.length() == 0)
			return true;
		if(memoMap.containsKey(sub)) 
			return memoMap.get(sub);
		for(String ea: wordDictSt) {
        	int len = ea.length();
        	if(sub.length() >= len && sub.substring(0, len).equals(ea) &&
        			(sub.length() == len || helperMemo(sub.substring(len), memoMap))) {
    			memoMap.put(sub.substring(0, len), true);
    			return true;
        	}
        }
		memoMap.put(sub, false);
		return false;
	}
	
	public static boolean wordBreakDP(String s, List<String> wordDict) {
		Set<String> words = new HashSet<String>(wordDict);
		boolean[] dpmemo = new boolean[s.length()+1];
		dpmemo[0] = true;
		for(int i=1; i<=s.length(); ++i) {
			for(int j=0;j<i;++j) {
				if(dpmemo[j] && words.contains(s.substring(j,i))) {
					dpmemo[i] = true;
				}
			}
		}
		return dpmemo[s.length()];
	}
	
	public static boolean wordBreakBST(String s, List<String> wordDict) {
		WordBreakNode root = new WordBreakNode('/');
		
		//Words tree
		for(String ea: wordDict) {
			WordBreakNode curr = root;
			for(int i=0;i<ea.length(); ++i) {
				if(!curr.nextMap.containsKey(ea.charAt(i))) 
					curr.nextMap.put(ea.charAt(i), new WordBreakNode(ea.charAt(i)));
				curr = curr.nextMap.get(ea.charAt(i));
			}
			curr.isWord = true;
		}
		
		Map<Integer, Boolean> memo = new HashMap();
		Deque<Integer> aq = new LinkedList();
		aq.add(0);
		while(!aq.isEmpty()) {
			WordBreakNode curr = root;
			Integer subIndex = aq.poll();
			if(memo.containsKey(subIndex)) {
				if(memo.get(subIndex)) return true;
			}else {
				for(int i=subIndex+0;i<s.length(); ++i) {
					if(curr.nextMap.containsKey(s.charAt(i))) {
						curr = curr.nextMap.get(s.charAt(i));
						if(curr.isWord) {
							aq.add(i+1);
						}
					}else {
						memo.put(subIndex, false);
						break;
					}
					if(i==s.length()-1 && (curr.nextMap.size() == 0 || curr.isWord)) {
						memo.put(subIndex, true);
						return true;
					}
				}
			}
		}
		return false;
	}
}
