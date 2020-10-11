package medium.amazon;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRUCacheMain {
    
	public static void main(String[] args) {
		LRUCacheBetter cache = new LRUCacheBetter(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);
		cache.put(3, 3);
		cache.get(2);
		cache.put(4, 4);
		cache.get(1);
		cache.get(3);
		cache.get(4);
	}
	
}

class LRUCache{
	LinkedHashMap<Integer, Integer> amap;
	Integer capacity;
	public LRUCache(int capacity) {
        amap = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	boolean isPresent = amap.containsKey(key);
    	if(isPresent) amap.put(key, amap.remove(key));
        return isPresent ? amap.get(key) : -1;
    }
    
    public void put(int key, int value) {
    	if(amap.size() == capacity && !this.amap.containsKey(key)){
    		Integer evictKey = amap.entrySet().iterator().next().getKey();
    		amap.remove(evictKey);
    	}
    	this.amap.remove(key);
    	this.amap.put(key, value);
    }
}

class DLNode{
	int key;
	int val;
	DLNode next;
	DLNode prev;
	
	public DLNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
}

class LRUCacheBetter{
	int capacity;
	int currSize;
	HashMap<Integer, DLNode> amap;
	DLNode head, tail;

	public LRUCacheBetter(int capacity) {
        this.head = new DLNode(-1, -1);
        this.tail = new DLNode(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
        this.amap = new HashMap();
    }
    
    int get(int key) {
        if(!this.amap.containsKey(key)) return -1;
        this.deleteNode(this.amap.get(key));
    	this.insertNext(this.head, this.amap.get(key));  
        return this.amap.get(key).val;
    }
    
    void put(int key, int value) {
        if(this.amap.containsKey(key)) {
        	DLNode curr = this.amap.get(key);
        	this.deleteNode(curr);
        	curr.val = value;
        	this.insertNext(this.head, curr);        	
        }else {
        	DLNode curr = new DLNode(key, value);
    		amap.put(key, curr);
        	if(this.capacity == this.currSize) {
        		amap.remove(this.tail.prev.key);
        		this.deleteNode(this.tail.prev);
        		this.currSize--;
        	}
        	this.insertNext(this.head, curr);
        	this.currSize++;
        }
    }
    
    void deleteNode(DLNode curr) {
    	curr.prev.next = curr.next;
    	curr.next.prev = curr.prev;
    }
    
    void insertNext(DLNode head, DLNode curr) {
    	curr.next = head.next;
    	head.next.prev = curr;
    	curr.prev = head;
    	head.next = curr;
    }
}


