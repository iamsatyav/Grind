package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Atuple{
	String name;
	int timestamp;
	String website;
	public Atuple(String name, int timestamp, String website) {
		super();
		this.name = name;
		this.timestamp = timestamp;
		this.website = website;
	}
	@Override
	public String toString() {
		return "Atuple [name=" + name + ", timestamp=" + timestamp + ", website=" + website + "]";
	}
	
}

class Trigram {
	String first;
	String second;
	String third;
	public Trigram(String first, String second, String third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		result = prime * result + ((third == null) ? 0 : third.hashCode());
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
		Trigram other = (Trigram) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		if (third == null) {
			if (other.third != null)
				return false;
		} else if (!third.equals(other.third))
			return false;
		return true;
	}
	
	public List<String> toList(){
		return new ArrayList(Arrays.asList(this.first, this.second, this.third));
	}
	
}

public class UserWebsiteUsagePattern1152 {
	public static void main(String[] args) {
		String[] username = {"zkiikgv","zkiikgv","zkiikgv","zkiikgv"};
		int[] timestamp = {436363475,710406388,386655081,797150921};
		String[] website = {"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"};
		List<String> res = mostVisitedPattern(username, timestamp, website);
		for(String ea:res) {
			System.out.print(ea+", ");
		}
	}
	
	public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<Atuple> alist = new ArrayList();
		for(int i=0; i<n; ++i) {
        	alist.add(new Atuple(username[i], timestamp[i], website[i]));
        }
		
		alist.sort((Atuple t1, Atuple t2) -> {
			if(t1.name.equals(t2.name)) {
				return t1.timestamp -t2.timestamp;
			}else {
				return t1.name.compareTo(t2.name);
			}
		});
		boolean equalCheck = false;
		int maxCount = 0;
		Trigram maxTri = null;
		HashMap<Trigram, Integer> temp = new HashMap();
		for(int i=1; i<alist.size(); ++i) {
			if(equalCheck && alist.get(i).name.equals(alist.get(i-1).name)) {
				Trigram curr = new Trigram(alist.get(i-2).website,
						alist.get(i-1).website,alist.get(i).website);
				int count = temp.getOrDefault(curr, 0)+1;
				if(count > maxCount) {
					maxCount = count;
					maxTri = curr;
				}else if(count == maxCount){
					if((curr.first+curr.second+curr.third).compareToIgnoreCase(
							maxTri.first+maxTri.second+maxTri.third) < 0) {
						maxTri = curr;
					}
				}
				temp.put(curr, count);
				
			}else {
				if(alist.get(i).name.equals(alist.get(i-1).name))
					equalCheck = true;
				else
					equalCheck = false;
			}
		}
		return maxTri==null ? null : Arrays.asList(maxTri.first, maxTri.second, maxTri.third);
    }
}
