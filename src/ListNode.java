
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        if (head==null || head.next==null){
	            return head;
	        }
	        
	        ListNode preHead=new ListNode(0);
	        preHead.next=head;
	        
	        ListNode pre=preHead;
	        ListNode current=head;
	        ListNode end=head;
	        
	
	        // find M point and N point
	        while (m>0 || n>0 ){
	            if (m>0){
	                pre=pre.next;
	                current=current.next;
	                --m;
	            }
	            
	            if (n>0){
	                end=end.next;
	                --n;
	            }
	        }
	        
	        // reverse from M point to N Point
	        reverse(pre, end.next);
	        return preHead.next;
	   }
	    
	   private void reverse(ListNode pre, ListNode endNext) {
	        ListNode cur=pre.next;
	        
	        while (cur.next!=endNext) {
	            ListNode next=cur.next;
	            ListNode temp=pre.next;
	            pre.next=next;
	            cur.next=next.next;
	        
	            next.next=temp; 
	        }
	    }
    
}