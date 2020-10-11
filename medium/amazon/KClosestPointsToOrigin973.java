package medium.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

class Node2{
	double distance;
	int[] coordinates;
	public Node2(double distance, int[] coordinates) {
		this.distance = distance;
		this.coordinates = coordinates;
	}
}

public class KClosestPointsToOrigin973 {
	public static void main(String[] args) {
		int[][] points  = {{1,3},{-2,2}};
		int K =1;
		kClosest(points, K);
	}
	
	//Divide and Conquer - Incomplete
	public static int[][] kClosestBetter(int[][] points, int K){
		double[] distances = new double[points.length];
		
		for(int i=0; i<points.length; ++i) {
			distances[i] = Math.sqrt(Math.pow(points[i][0], 2) 
        			+ Math.pow(points[i][1], 2));
		}
		double pivot = distances[0];
		int curr = 0;
		for(int i=1; i<distances.length; ++i) {
			if(distances[i] < pivot) {
				int[] temp = points[curr];
				points[curr] = points[i];
				points[i] = temp;
				
				double tem = distances[curr];
				distances[curr] = distances[i];
				distances[i] = tem;
				curr++;
			}
		}
		
		if(curr == K) {
			return Arrays.copyOfRange(points, 0, curr);
		}else if(curr < K) {
			
		}else {
			
		}
		return null;
	}
	
	public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Node2> apq = new PriorityQueue<>((n1, n2) -> {
        	if(n1.distance - n2.distance < 0) return -1;
        	return 1;
        });
        
        for(int i=0; i< points.length; ++i) {
        	apq.add(new Node2(Math.sqrt(Math.pow(points[i][0], 2) 
        			+ Math.pow(points[i][1], 2)), points[i]));
        }
        int[][] res = new int[K][2];
        for(int i=0; i<K; ++i) {
        	res[i] = apq.poll().coordinates;
        }
        return res;
    }
}
