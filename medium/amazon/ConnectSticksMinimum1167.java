package medium.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectSticksMinimum1167 {
	public static void main(String[] args) {
		int[] sticks = {3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
		//int[] sticks = {1,8,3,5};
		System.out.println(connectSticks(sticks));
	}
	
	public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> stickHeap = new PriorityQueue();
        for(int ea: sticks) {
        	stickHeap.offer(ea);
        }
        
        int res = 0;
        while(stickHeap.size() >= 2) {
        	int currStick = stickHeap.poll() + stickHeap.poll();
        	res += currStick;
        	stickHeap.add(currStick);
        }
        return res;
    }
}
