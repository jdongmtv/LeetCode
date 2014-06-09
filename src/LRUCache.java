import java.util.HashMap;


public class LRUCache {

		HashMap<Integer,DoubleLinkedListNode> map;
		DoubleLinkedListNode head;
		DoubleLinkedListNode end;
		int current = 0;
		int capacity = 0;
		
	    LRUCache(int capacity) {
	        map = new HashMap<>();
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	    	DoubleLinkedListNode node = map.get(key);
	    	if(node != null) {
	    		removeNode(node);
	    		setHead(node);
	    		return node.val;
	    	}
	        return -1;
	    }
	    
	    private void setHead(DoubleLinkedListNode node) {
	    	if(head == null) {
	    		head = node;
	    		end = node;
	    	} else {
	    		node.next = head;
	    		head.pre = node;
	    		node.pre = null;
	    		head = node;
	    	}
		}

		private void removeNode(DoubleLinkedListNode node) {
			if(node.pre != null) {
				node.pre.next = node.next;
			} else {
				head = node.next;
			}
			if(node.next != null) {
				node.next.pre = node.pre;
			} else {
				end = node.pre;
			}
		}

		public void set(int key, int value) {
	       DoubleLinkedListNode node = map.get(key);
	       if(node == null) {
	    	   if(current == capacity) {
	    		   node = new DoubleLinkedListNode(key,value);
	    		   map.put(key, node);
	    		   removeNode(end);
	    		   setHead(node);
	    	   } else {
	    		   ++current;
	    		   node = new DoubleLinkedListNode(key,value);
	    		   setHead(node);
	    	   }
	       } else if(node != null) {
	    	   node.val = value;
	    	   removeNode(node);
	    	   setHead(node);
	       }
	    }
	    
	    private static class DoubleLinkedListNode {
	    	DoubleLinkedListNode pre;
	    	DoubleLinkedListNode next;
	    	/** package */int key;
	    	/** package */int val;
	    	
	    	public DoubleLinkedListNode(int key, int val) {
	    		this.key = key;
	    		this.val = val;
			}
	    }
	    
}
