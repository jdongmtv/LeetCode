
public class RandomListNode {
	
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { 
	 this.label = x; 
	}
	
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode p = head;
        while(p!=null) {
        	RandomListNode node = new RandomListNode(p.label);
        	node.next = p.next;
        	p.next = node;
        	p = node.next;
        }
        p = head;
        while(p!=null) {
        	if(p.random != null)
        		p.next.random = p.random.next;
        	p = p.next.next;
        }
        p = head;
        RandomListNode q = p.next;
        dummy.next = q;
        while(p!=null) {
        	p.next = p.next.next;
        	if(q.next != null)
        		q.next = q.next.next;
        	p = p.next;
        	q = q.next;
        }
        return dummy.next;
    }
    
}
