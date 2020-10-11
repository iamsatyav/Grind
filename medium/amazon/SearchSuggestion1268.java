package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class Trie{
	Character val;
	String word;
	Trie[] nextArr;
	boolean isWord;
	boolean isLast;
	public Trie(Character val, String word) {
		super();
		this.val = val;
		this.nextArr = new Trie[26];
		this.isWord = false;
		this.isLast = true;
		this.word = word;
	}
}

public class SearchSuggestion1268 {
	public static void main(String[] args) {
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		suggestedProductsSecond(products, searchWord);
	}
	
	public static List<List<String>> suggestedProductsSecond(String[] products, String searchWord) {
		SortedSet<String> aset = new TreeSet();
		for(String ea: products) {
			aset.add(ea);
		}
		List<List<String>> res = new ArrayList();
		for(int i=0; i<searchWord.length(); ++i) {
			List<String> curr = new ArrayList<String>();
			String sub = searchWord.substring(0, i+1);
			Iterator<String> it = aset.tailSet(sub).iterator();
			int cnt = 1;
			while(it.hasNext() && cnt < 4) {
				String s = it.next();
				if(s.length() > sub.length() && s.substring(0, sub.length()).equals(sub))
					curr.add(s);
				cnt++;
			}
			res.add(curr);
		}
		System.out.println("Hello");
		return null;
	}
	
	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Trie root = new Trie(null, "");
		
		//building Trie
		for(String ea: products) {
			Trie curr = root;
			for(int j=0; j<ea.length(); ++j) {
				if(curr.nextArr[ea.charAt(j)-'a'] == null) { 
					curr.nextArr[ea.charAt(j)-'a'] = new Trie(ea.charAt(j), 
							curr.word+Character.toString(ea.charAt(j)));
					curr.isLast = false;
				}
				curr = curr.nextArr[ea.charAt(j)-'a'];
			}
			curr.isWord = true;
			
		}
		
		//searching word
		List<List<String>> res = new ArrayList();
		for(int i=0; i<searchWord.length();++i) {
			Trie curr = root;
			String currWord = searchWord.substring(0, i+1);
			for(int j=0; j<=i;++j) {
				curr = curr.nextArr[currWord.charAt(j)-'a'];
				if(curr == null)
					break;
			}
			if(curr!=null) {
				List<String> currList = helperIterative(curr);
				res.add(currList);
			}else {
				res.add(new ArrayList());
			}
			
		}
		System.out.println(Arrays.deepToString(res.toArray()));
		return res;
    }
	
	public static List<String> helperRecursive(Trie curr, String currWord, List<String> currList){
		 if(currList.size() == 3)
			 return currList;
		 
		 if(curr.isLast) currList.add(currWord);
		 else {
			 if(curr.isWord) currList.add(currWord);
			 for(int i=0; i<curr.nextArr.length; ++i) {
				 if(currList.size() == 3) return currList;
				 if(curr.nextArr[i] != null) {
					 currList = helperRecursive(curr.nextArr[i], currWord.concat(
							 Character.toString(curr.nextArr[i].val)), currList);
				 }
			}
		 }
		return currList;
	}
	
	public static List<String> helperIterative(Trie curr){
		List<String> res = new ArrayList();
		if(curr.isLast) {
			res.add(curr.word);
			return res;
		}else {
			Deque<Trie> stack = new LinkedList();
			stack.push(curr);
			while(!stack.isEmpty()) {
				Trie temp = stack.pop();
				if(temp.isWord || temp.isLast) res.add(temp.word);
				if(res.size() == 3) return res;
				for(int i=temp.nextArr.length-1; i>=0; --i) {
					 if(temp.nextArr[i] != null) {
						 stack.push(temp.nextArr[i]);
					 }
				}
			}
			return res;
		}
	}
}
