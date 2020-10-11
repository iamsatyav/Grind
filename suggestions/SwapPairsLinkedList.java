package suggestions;

class Node{
	Node next;
	int val;
	public Node(int val) {
		this.val = val;
	}
}

public class SwapPairsLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node curr = head;
		for(int i =2; i< 10; ++i) {
			curr.next = new Node(i);
			curr = curr.next;
		}
		Node resHead = swapPairs(head);
		while(resHead!=null) {
			System.out.println(resHead.val);
			resHead = resHead.next;
		}
	}
	
	public static Node swapPairs(Node head) {
		Node curr = head;
		Node res = head.next;
		while(curr!=null && curr.next!=null) {
				Node temp = curr.next;
				if(curr.next.next!=null && curr.next.next.next!=null)
					curr.next = curr.next.next.next;
				else
					curr.next = curr.next.next;
				temp.next =  curr;
				curr = curr.next;
		}
		return res;
	}
}
