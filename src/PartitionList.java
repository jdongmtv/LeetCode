
public class PartitionList {
	
	public static ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(-1);
		ListNode middle = new ListNode(-1);
		ListNode p = dummy, q = middle;
		while(head != null) {
			if(head.val<x) {
				p.next = head;
				p = p.next;
			} else {
				q.next = head;
				q = q.next;
			}
			head = head.next;
		}
		q.next = null; //so important or there may be a circle, then TLE
		p.next = middle.next;
		return dummy.next;
	}
	
	  public ListNode rotateRight(ListNode head, int n) {
	       if(head == null || n==0)
	    	   	return head;
	       ListNode dummy = new ListNode(-1);
	       dummy.next = head;
	       ListNode p = dummy, q = dummy;
	       int len = 0;
	       while(p.next!=null) {
	           p = p.next;
	           ++len;
	       }
	       p = dummy;
	       n = n%len;
	       while(--n>=0){
	    	   q = q.next;
	       }
	       while(q.next != null) {
	    	   p = p.next;
	    	   q = q.next;
	       }
	       q.next = dummy.next;
	       dummy.next = p.next;
	       p.next = null;
	       return dummy.next;
	 }
    
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		partition(head, 2);
	}
	
}
