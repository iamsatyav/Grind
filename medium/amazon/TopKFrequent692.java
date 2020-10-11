package medium.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class Tup2{ 
	String word;
	int count;
	public Tup2(String  word, int count) {
		this.word=word;
		this.count= count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tup2 other = (Tup2) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	
}

public class TopKFrequent692 {
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		List<String> res = topKFrequent2(words, k);
		for(String ea: res) {
			System.out.print(ea+" ");
		}
	}
	
	//First Try - Incorrect
	public static List<String> topKFrequent(String[] words, int k){
		SortedSet<Tup2> aset = new TreeSet<Tup2>((Tup2 t1, Tup2 t2)->{
			if(t1.count < t2.count)
				return 1;
			return 0;
		});
		
		for(int i=0; i<words.length; ++i) {
			Tup2 curr = new Tup2(words[i], 1);
			if(aset.contains(curr)) {
				Tup2 temp = aset.tailSet(curr).first();
				curr.count = temp.count +1;
			}
			aset.add(curr);
		}
		List<String> res = new ArrayList();
		Iterator<Tup2> it = aset.iterator();
		while(k>0) {
			res.add(it.next().word);
		}
		return res;
	}
	
	//Leetcode 1
	public static List<String> topKFrequent2(String[] words, int k){
		HashMap<String, Integer> amap = new HashMap<>();
		for(int i=0; i<words.length; ++i) {
			amap.put(words[i], amap.getOrDefault(words[i], 0)+1);
		}
		List<String> alist = new ArrayList(amap.keySet());
		Collections.sort(alist, (w1, w2) -> {
			return (amap.get(w1) == amap.get(w2)) ? w1.compareTo(w2) :  amap.get(w2) - amap.get(w1);
		});
		return alist;
	}
}
