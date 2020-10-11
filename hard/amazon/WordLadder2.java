package hard.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordLadder2 {
	static HashMap<String, List<String>> transformMap;
    static List<List<String>> result;
    static int minPath;
    
    public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		findLadders(beginWord, endWord, wordList);
		
	}
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        result = new ArrayList();
        transformMap= new HashMap();
        minPath = Integer.MAX_VALUE;
        for(String word: wordList){
            char[] charArr = word.toCharArray();
            for(int i=0; i<word.length(); ++i){
                charArr[i] = '*';
                String transformString = new String(charArr);
                if(!transformMap.containsKey(transformString))
                    transformMap.put(transformString, new ArrayList());
                transformMap.get(transformString).add(word);
                charArr[i] = word.charAt(i);
            }
        }
        helper(beginWord, endWord, new HashSet(Arrays.asList(beginWord)));
        List<List<String>> res = new ArrayList();
        for(List<String> ea: result) {
        	if(ea.size()==minPath)
        		res.add(ea);
        } 
        return res;
    }
    
    public static void helper(String beginWord, String endWord, HashSet<String> currPath){
        if(beginWord.equals(endWord)) {
        	List<String> currRes = new ArrayList(currPath);
        	if(currRes.size() < minPath){
        		minPath = currRes.size();
        		result.add(currRes);
            }
            return;
        }
        if(currPath.size() > minPath)  return;
        char[] charArr = beginWord.toCharArray();
        for(int i=0; i<beginWord.length(); ++i){
            charArr[i] = '*';
            String transformString = new String(charArr);
            if(transformMap.containsKey(transformString)){
                for(String nextWord: transformMap.get(transformString)){
                    if(currPath.contains(nextWord)) continue;
                    HashSet<String> tempPath = new HashSet(currPath);
                    tempPath.add(nextWord);
                    helper(nextWord, endWord, tempPath);
                }
            }
            charArr[i] = beginWord.charAt(i);
        }
        return;
    }
}
