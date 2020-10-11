package medium.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

class MeetingPair {
	int count, endTime;

	public MeetingPair(int count, int endTime) {
		super();
		this.count = count;
		this.endTime = endTime;
	}
	
}

public class MeetingRooms2_253 {
	public static void main(String[] args) {
		int[][] intervals = {{0, 30},{5, 10},{15, 2}};
		System.out.println(minMeetingRooms(intervals));
	}
	
	public static int minMeetingRoomsBrute(int[][] intervals) {
		int res = 0;
        for(int i=0; i<intervals.length; ++i) {
        	int currEnd = intervals[i][1];
        	int count = 0;
        	for(int j=0; j<intervals.length; ++j) {
        		if(intervals[j][0] < currEnd && intervals[j][1] >= currEnd)
        			count++;
        	}
        	if(count > res) res = count;
        }
        return res;
    }
	
	public static int minMeetingRooms(int[][] intervals) {
		
		if(intervals.length==0) return 0;
		if(intervals.length == 1)  return 1;
		Arrays.sort(intervals, (int[] a,int[] b) ->{
			return a[0] - b[0];
		});
		
		PriorityQueue<Integer> apq = new PriorityQueue();
		apq.add( intervals[0][1]);
		for(int i=1; i<intervals.length; ++i) {
			if(apq.peek() <= intervals[i][0]) {
				apq.poll();
				apq.add(intervals[i][1]);
			}else {
				apq.add(intervals[i][1]);
			}
		}
		return apq.size();
	}
}


