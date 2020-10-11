package dailyChanllengeWeek2;

public class MinStackMain {
	public static void main(String[] args) {
		MinStack myStack = new MinStack();
		myStack.push(-2);
		myStack.push(0);
		myStack.push(-3);
		System.out.println(myStack.getMin());
		myStack.pop();
		System.out.println(myStack.top());
		System.out.println(myStack.getMin());
	}
}
