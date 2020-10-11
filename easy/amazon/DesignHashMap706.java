package easy.amazon;

class MapNode {
    int key;
    int val;
    MapNode next;
    public MapNode(int key, int val){
        this.val = val;
        this.key = key;
    }
}

class MyHashMap {
    MapNode[] bucketArr;
    int arrSize;
    /** Initialize your data structure here. */
    public MyHashMap() {
    	this.arrSize = 4;
        this.bucketArr =  new MapNode[this.arrSize];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        MapNode curr = new MapNode(key, value);
        MapNode head = bucketArr[Math.abs(key%this.arrSize)];
        if(head == null){
           bucketArr[Math.abs(key%this.arrSize)] = curr;
            return;
        }
        else{
            while(head.next != null){
                if(head.key == key){
                    head.val = value;
                    return;
                }
                head = head.next;
            }
            if(head.key == key)
                head.val = value;
            else
            	head.next = curr;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        MapNode head = bucketArr[Math.abs(key%this.arrSize)];
        if(head == null) return -1;
        else{
            while(head !=  null){
                if(head.key == key) return head.val;
                head = head.next;
            }
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        MapNode head = bucketArr[Math.abs(key%this.arrSize)];
        if(head == null) return;
        if(head.key == key){
            bucketArr[Math.abs(key%this.arrSize)] = head.next;
            return;
        }
        MapNode dummy = new MapNode(1,1);
        dummy.next = head;
        while(head != null){
            if(head.key == key){
                dummy.next =  head.next;
                return;
            }
            else{
                head = head.next;
                dummy = dummy.next;
            }
        }
        return;
    }
}


public class DesignHashMap706 {
	public static void main(String[] args) {
		MyHashMap obj = new MyHashMap();
		obj.put(3, 2);
		obj.put(75, 1);
		obj.put(3, 10);
		obj.put(75, 65);
		System.out.println("");
	}
}
