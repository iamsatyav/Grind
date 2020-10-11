package medium.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class CourseNode{
	int val;
	List<CourseNode> nexts;
	Set<CourseNode> removed;
	public CourseNode(int val) {
		this.val = val;
		this.nexts = new ArrayList();
		this.removed = new HashSet();
	}
}

public class CourseSchedule2_210 {
	static Map<Integer, List<Integer>> adjList = new HashMap();
	static Map<Integer, Integer> stateCode = new HashMap(); // 0-not visited,1-current dfs path,2-added to result
	static List<Integer> topologicalOrder = new ArrayList();
	
	public static void main(String[] args) {
		int[][] prerequisites = {};
		int numCourses = 2;
		findOrderTopological(numCourses, prerequisites);
	}
	
	public static int[] findOrderTopological(int numCourses, int[][] prerequisites) {
		
		
		for(int i=0; i<numCourses; ++i) {
			stateCode.put(i, 0);
			adjList.put(i, new ArrayList());
		}
		
		for(int[] ea: prerequisites) {
			adjList.get(ea[1]).add(ea[0]);
		}
		
		for(Entry<Integer, Integer> ea: stateCode.entrySet()) {
			if(ea.getValue()==0)
				if(!dfs(ea.getKey())) return new int[0];
		}
		
		int[] res = new int[numCourses];
		for(int i=0; i<numCourses; ++i) {
			res[numCourses-i-1] = topologicalOrder.get(i);
		}
		return res;
	}
	
	public static boolean dfs(Integer node) {
		stateCode.put(node, 1);
		for(Integer ea: adjList.get(node)) {
			if(stateCode.get(ea)==1)
				return false;
			else if(stateCode.get(ea)==0)
				if(!dfs(ea)) return false;
		}
		
		stateCode.put(node, 2);
		topologicalOrder.add(node);
		return true;
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, CourseNode> amap = new HashMap();
        Map<Integer, Boolean> sources = new HashMap();
        for(int[] ea: prerequisites) {
        	if(!amap.containsKey(ea[1])) amap.put(ea[1], new CourseNode(ea[1]));
        	if(!amap.containsKey(ea[0])) amap.put(ea[0], new CourseNode(ea[0]));
        	
        	if(amap.get(ea[0]).nexts.contains(amap.get(ea[1])) || 
        			amap.get(ea[0]).removed.contains(amap.get(ea[1]))) return new int[0];
        	amap.get(ea[1]).nexts.add(amap.get(ea[0]));
        	amap.get(ea[1]).nexts.removeAll(amap.get(ea[0]).nexts);
        	amap.get(ea[1]).removed.addAll(amap.get(ea[0]).nexts);
        	
    		sources.putIfAbsent(ea[1], true);
    		sources.put(ea[0], false);
        }
        
        for(int i=0; i<numCourses; ++i) {
        	if(!amap.containsKey(i)) {
        		amap.put(i, new CourseNode(i));
        		sources.put(i, true);
        	}
        }
        Deque<CourseNode> aq = new LinkedList();
        boolean notPossible = true;
        for(Integer ea : sources.keySet()) {
        	if(sources.get(ea)) {
        		notPossible = false;
        		aq.add(amap.get(ea));
        		sources.put(ea, false); // for reuse below
        	}
        }
        
        int[] res = new int[numCourses];
        int currIndex = 0;
        while(!aq.isEmpty() && currIndex<numCourses) {
        	CourseNode curr = aq.poll();
        	sources.put(curr.val, true);
        	res[currIndex++] = curr.val;
        	for(CourseNode ea: curr.nexts) {
        		if(!sources.get(ea.val)) {
        			aq.add(ea);
        		}
        	}
        }
        System.out.println(Arrays.toString(res));
        return notPossible ? new int[0] : res;
    }
}
