import java.util.LinkedList;
import java.util.Queue;

public class Trinary {
	
	static class Node {
		int value;
		Node[] children;
		Node(int value) {
			this.value = value;
			children = new Node[3];
		}
	}
	
	static final int LEFT = 0;
	static final int MIDDLE = 1;
	static final int RIGHT = 2;
	
	int size = 0;
	Node root;
	
	void insert(int key) {
		insert(new Node(key));
	}
	
	void insert(Node node) {
		if(node == null)
			throw new NullPointerException();
		
		if(root == null) {
			root = node;
			++size;
			return;
		}
		
		Node pre = null;
		int tag = -1;
		Node p = root;
		while(p!=null) {
			if(p.value == node.value) {
				pre = p;
				tag = MIDDLE;
				p = p.children[MIDDLE]; 
			} else if(p.value > node.value) {
				pre = p;
				tag = LEFT;
				p = p.children[LEFT];
			} else {
				pre = p;
				tag = RIGHT;
				p = p.children[RIGHT];
			}
		}
		pre.children[tag] = node;
		++size;
	}
	
	void delete(int key) {
		//preserve the searching node's parent info
		//use array, because java is passed by value, a simple trick
		Node[] parent = new Node[1];
		int[] parentTag = new int[1];
		Node node = search(key,parent,parentTag);
		
		delete(node,parent,parentTag);
	}
	
	private Node search(int key, Node[] parent, int[] parentTag) {
		Node p = root;
		while(p!=null) {
			if(p.value == key)
				break;
			else if(p.value>key) {
				parent[0] = p;
				parentTag[0] = LEFT;
				p = p.children[LEFT];
			} else {
				parent[0] = p;
				parentTag[0] = RIGHT;
				p = p.children[RIGHT];
			}
		}
		return p;
	}

	void delete(Node node, Node[] parent, int[] parentTag) {
		if(node == null)
			throw new NullPointerException();
		
		--size;
		int tag = -1;
		Node pre = node;
		Node p = node;
		
		//replace the node  with an equal value,then return
		if(p.children[MIDDLE] != null) {
			while(p.children[MIDDLE] != null) {
				pre = p;
				tag = MIDDLE;
				p = p.children[MIDDLE];
			}
			pre.children[tag] = null;
			return;
		}
		
		// replace with left children's right most, then return
		if(p.children[LEFT] != null) {
			pre = p;
			tag = LEFT;
			p = p.children[LEFT];
			
			while(p.children[RIGHT] != null) {
				pre = p;
				tag = RIGHT;
				p = p.children[RIGHT];
			}
			while(p.children[MIDDLE] != null) {
				pre = p;
				tag = MIDDLE;
				p = p.children[MIDDLE];
			}
			
			node.value = p.value;
			pre.children[tag] = p.children[LEFT];
			//special case
			if(node.children[LEFT] != null && node.children[LEFT].value == node.value) {
				   node.children[MIDDLE] = node.children[LEFT];
				   node.children[LEFT] = null;
			}   
			return;
		}
		
		// replace with right children's left most, then return
		if(p.children[RIGHT] != null) {
			pre = p;
			tag = RIGHT;
			p = p.children[RIGHT];
			
			while(p.children[LEFT] != null) {
				pre = p;
				tag = LEFT;
				p = p.children[LEFT];
			}
			
			while(p.children[MIDDLE] != null) {
				pre = p ;
				tag = MIDDLE;
				p = p.children[MIDDLE];
			}
			
			node.value = p.value;
			pre.children[tag] = p.children[RIGHT];
			//special case
			if(node.children[RIGHT]!=null && node.children[RIGHT].value == node.value){
				node.children[MIDDLE] = node.children[RIGHT];
				node.children[RIGHT] = null;
			}
			return;
		}
		
		//only one node , delete it 
		if(parent[0] != null) {
			parent[0].children[parentTag[0]] = null;
		} else { 
			//parent is null, delete the root
			root = null;
		}
	}
	
	int size() {
		return size;
	}
	
	Node getRoot() {
		return root;
	}
	
	void printByLevel() {
		Queue<Node> queue = new LinkedList<>();
		if(root!=null)
			queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.err.print(node.value + " ");
			if(node.children[LEFT] != null) 
				queue.add(node.children[LEFT]);
			if(node.children[MIDDLE] != null) 
				queue.add(node.children[MIDDLE]);
			if(node.children[RIGHT] != null) 
				queue.add(node.children[RIGHT]);
		}
		System.err.println();
	}
	
	public static void main(String[] args) {
		Trinary trinary = new Trinary();
		int arr[] = {5, 4, 9, 5, 7, 2, 2};
		for(int i=0;i<arr.length;i++) {
			trinary.insert(arr[i]);
		}
		
		System.err.println("Insert Completed, tree size is：" + trinary.size());
		trinary.printByLevel();
		
		for(int i=0;i<arr.length;i++) {
			trinary.delete(arr[i]);
			System.err.println("Delete element  " + arr[i] +" tree size is：" + trinary.size());
			trinary.printByLevel();
	    }
   }
	
}
