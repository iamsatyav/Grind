package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class VersionNumbers165 {
	public static void main(String[] args) {
		String s = "asd";
		String se = new String(new char[] {'a'});
		HashSet<String> aset = new HashSet(Arrays.asList("asd"));
		List<String> alist = new ArrayList(aset);
		alist.add("asd");
		List<List<String>> blist = new ArrayList();
		blist.add(alist);
		HashSet<String> bset = new HashSet(aset);
	} 
	
//	public static int compareVersion(String version1, String version2) {
//        String[] v1 = version1.split("\\.");
//        String[] v2 = version2.split("\\.");
//        
//    }
}
