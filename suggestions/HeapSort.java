package suggestions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = new int[] {3,2,7,4,5,1,6,8,9};
		for(int i=arr.length/2-1;i>=0;i--) {
			heapify(arr, arr.length, i);
		}
		for(int i=arr.length-1; i>0; --i) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(arr, i, 0);
		}
		printArr(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//max heap
	//Note: Heapify can only be applied of the left and right subtrees satisfy heap property!!
	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		//check left child
		if(l<n && arr[l] > arr[largest])
			largest = l;
		//check right child
		if(r<n && arr[r]>arr[largest])
			largest = r;
		
		//time to swap
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			//heapify the subtree that got affected
			heapify(arr, n, largest);
		}
	}
	
	public static void printArr(int[] arr) {
		for(int i=0; i<=arr.length/2-1; ++i) {
			System.out.print(arr[i]+" -> ");
			if(2*i+1 < arr.length) System.out.print(arr[2*i+1]+" ");
			if(2*i+2 < arr.length) System.out.print(arr[2*i+2]+" ");
			System.out.println();
		}
	}
}
