import java.util.LinkedHashMap;
import java.util.LinkedList;


public class LRUCache {
	
	private int capacity;
	private LinkedHashMap<Integer,Integer> hashMap ;
	private LinkedList<Integer> linkedList;
	
	public LRUCache(int capacity) {
	   this.capacity = capacity;
	   hashMap = new LinkedHashMap<Integer,Integer>(capacity);  
	   linkedList = new LinkedList<Integer>();
	}
	
	public int get(int key) {
	    if(hashMap.containsKey(key)) {
	        linkedList.remove(new Integer(key));
			linkedList.addFirst(key);
		    return hashMap.get(key);
	    }
		else
		    return -1;
	}
	
	public void set(int key, int value) {
	  if(linkedList.size() < capacity) {
		  if(!hashMap.containsKey(key))
			  linkedList.addFirst(key);
		  else {
		      linkedList.remove(new Integer(key));
			  linkedList.addFirst(key);
		  }
		  hashMap.put(key, value);
	  } else {
		  int evicted = linkedList.removeLast();
		  hashMap.remove(evicted);
		  hashMap.put(key, value);
	  }
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(2,2);
		cache.get(2);
		cache.set(1,1);
		cache.set(4,1);
		cache.get(2);
	}
}
