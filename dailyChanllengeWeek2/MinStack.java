package dailyChanllengeWeek2;

import java.util.ArrayList;
import java.util.List;
public class MinStack {
	
	List<Integer[]> myList;
	
	public MinStack() {
		this.myList = new ArrayList<Integer[]>();
	}

	public void push(int x) {
		int currMin = x;
		if(!myList.isEmpty() && currMin>myList.get(0)[1]) { 
			currMin = myList.get(0)[1];
		}
		myList.add(0, new Integer[]{x, currMin});
	}

	public void pop() {
		myList.remove(0);
	}

	public int top() {
		return myList.get(0)[0];
	}

	public int getMin() {
		return myList.get(0)[1];
	}
}
