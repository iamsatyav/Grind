package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WordNode{
	String word;
	Integer level;
	public WordNode(String word, Integer level) {
		super();
		this.word = word;
		this.level = level;
	}
}

public class WordLadder127 {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
		int res = ladderLength(beginWord, endWord, wordList);
		System.out.println(res);
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int L = beginWord.length();
		Map<String, List<String>> neighborsMap = new HashMap();
		wordList.forEach(
				word -> {
					for(int i=0; i<L;++i) {
						String newWord = word.substring(0,i)+'*'+word.substring(i+1, L);
						List<String> neighbors = neighborsMap.getOrDefault(newWord, new ArrayList());
						neighbors.add(word);
						neighborsMap.put(newWord, neighbors);
					}
				});
		
		Deque<WordNode> aq = new LinkedList();
		Set<String> visited = new HashSet();
		aq.add(new WordNode(beginWord, 1));
		while(!aq.isEmpty()) {
			WordNode curr = aq.poll();
			if(curr.word.equals(endWord)) return curr.level;
			visited.add(curr.word);
			for(int i=0; i<L; ++i) {
				List<String> neighbors = neighborsMap.get(
						curr.word.substring(0,i)+'*'+curr.word.substring(i+1,L));
				if(neighbors != null) {
					neighbors.forEach(neighbor -> {
						if(!visited.contains(neighbor)) {
							aq.add(new WordNode(neighbor, curr.level+1));
						}
					});
				}
				
			}
		}
		return 0;	
    }
	
		
}
