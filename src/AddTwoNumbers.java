
public class AddTwoNumbers {
	
	  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(-1);
	        ListNode p = dummy;
	        int carry = 0;
	        while(carry!=0 || l1 != null || l2 != null) {
	        	
	        	int sum = carry;
	        	if(l1 != null) {
	        		sum = sum + l1.val;
	        		l1 = l1.next;
	        	}
	        	if(l2 != null) {
	        		sum = sum + l2.val;
	        		l2 = l2.next;
	        	}
	        	p.next = new ListNode(sum%10);
	        	p = p.next;
	        	carry = sum/10;
	        }
	        return  dummy.next;
	  }
	  
}
