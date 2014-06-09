public class LinkedList {
	
    public boolean hasCycle(ListNode head) {   	
      ListNode fast = head, slow = head;
      while(fast != null) {
    	  slow = slow.next;
    	  if(fast.next != null)
    		  fast = fast.next.next;
    	  else
    		  break;
    	  if(slow == fast)
    		  return true;
      }
      return false;
   }
   
   public ListNode detectCycle(ListNode head) {
	   
	      ListNode fast = head, slow = head;
	      
	      while(true) {
	         if(fast == null)
	    	    return null;
	    	  slow = slow.next;
	    	  if(fast.next != null)
	    		  fast = fast.next.next;
	    	  else
	    		  return null;
	    	  if(slow == fast) {
	    		  break;
	    	  }
	      }
	      
	      while(head != slow) {
	    	  head = head.next;
	    	  slow = slow.next;
	      }
	      
	      return slow;
    }
   
   public void reorderList(ListNode head) {
       
   }
   
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	   ListNode dummy = new ListNode(-1);
	   ListNode p = dummy;
	   while(l1!=null && l2!=null) {
		   if(l1.val >= l2.val) {
			   p.next = l1;
			   l1 = l1.next;
		   } else {
			   p.next = l2;
			   l2 = l2.next;
		   }
		   p = p.next;
	   }
	   if(l1!=null)
		   p.next = l1;
	   if(l2 != null)
		   p.next = l2;
	   return dummy.next;
   }
   
   public ListNode rotateRight(ListNode head, int n) {
       ListNode dummy = new ListNode(-1);
       return dummy.next;
   }
   
}
