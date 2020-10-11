package medium.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;
 
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyWithRandomPointer138 {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		head.next = second;
		second.next = third;
		third.next = null;
		head.random = third;
		second.random = head;
		third.random = head;
		
		Node res = copyRandomList(head);
		System.out.println("Hello");
	}
	
	public static Node copyRandomList(Node head) {
		if(head==null) return null;
        Map<Node, Node> amap = new HashMap();
        Node curr = head;
        Node newCurr = new Node(head.val);
        Node dummy = new Node(0);
        dummy.next = newCurr;
        amap.put(curr, newCurr);
        while(curr.next!=null) {
        	Node newCurrNext = new Node(curr.next.val);
        	newCurr.next = newCurrNext;
        	amap.put(curr.next, newCurr.next);
        	newCurr = newCurr.next;
        	curr = curr.next;
        }
        
        //second pass random pointer
        curr = head;
        newCurr = dummy.next;
        while(curr!=null) {
        	newCurr.random = curr.random == null ? null : amap.get(curr.random);
        	newCurr = newCurr.next;
        	curr = curr.next;
        }
        return dummy.next;
    }
}
