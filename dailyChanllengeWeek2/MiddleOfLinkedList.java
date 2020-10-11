package dailyChanllengeWeek2;

public class MiddleOfLinkedList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		ListNode head = __LinkedListService.getLinkedList(arr);
		ListNode slow = head, fast=head;
		while(fast != null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.val);
	}
}
