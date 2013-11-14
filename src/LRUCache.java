import java.util.HashMap;


public class LRUCache {
	
	private int capacity;
	private HashMap<Integer,Node> hashMap ;
	private DoublyLinkedList linkedList;
	
	public LRUCache(int capacity) {
	   this.capacity = capacity;
	   hashMap = new HashMap<Integer,Node>(capacity);  
	   linkedList = new DoublyLinkedList(capacity);
	}
	
	public int get(int key) {
	    if(hashMap.containsKey(key)) {
	    	Node node  = hashMap.get(key);
	        linkedList.remove(node);
			linkedList.addFirst(node);
		    return node.data;
	    } else {
		    return -1;
	    }
	}
	
	public void set(int key, int value) {
	  Node node;
	  if(linkedList.size() < capacity) {
		  if(!hashMap.containsKey(key)) {
			  node  = new Node(value);
			  linkedList.addFirst(node);
		  } else {
			  node = hashMap.get(key);
			  linkedList.remove(node);
			  linkedList.addFirst(node);
		  }
		  hashMap.put(key, node);
	  } else {
		  int evicted = linkedList.removeLast();
		  hashMap.remove(evicted);
		  node = new Node(value);
		  linkedList.addFirst(node);
		  hashMap.put(key, node);
	  }
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		cache.set(2,1);
		cache.get(2);
		cache.set(3,2);
		cache.get(2);
		cache.get(3);
	}
	
	private static class DoublyLinkedList {
		
		private Node head;
		private Node tail;
		private int size;
		
		public DoublyLinkedList(int size) {
			head = new Node(-1);
			tail = head;
		}
		
		public void addFirst(Node node) {
			++size;
			node.next = head.next;
			node.pre = head;
			if(node.next != null)
				node.next.pre = node;
			head.next = node;
			if(node.next == null)
				tail = node;
		}
		
		public void remove(Node node) {
			--size;
			if(node.next == null) {
				removeLast();
			} else {
				Node pre = node.pre;
				Node nextNode = node.next;
				if(pre != null)
				 pre.next = nextNode;
			}
		}
		
		public int removeLast() {
			--size;
			Node pre = tail.pre;
			pre.next = null;
			tail.pre = null;
			tail = pre;
			return tail.data;
		}
		
		public int size() {
			return size;
		}
		
	}
	
	private static class Node {
		int data;
		Node pre;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
