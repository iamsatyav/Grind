package dailyChanllengeWeek2;


class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

public class __LinkedListService {
	public static ListNode getLinkedList(int[] arr) {
		ListNode head = new ListNode(arr[0]);
		ListNode curr = head;
		for(int i=1; i< arr.length; ++i) {
			curr.next = new ListNode(arr[i]);
			curr = curr.next;
		}
		curr.next = null;
		return head;
	}
	
	public static void printLinkedList(ListNode curr) {
		while(curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
	}
}
