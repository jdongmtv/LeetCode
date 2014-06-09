
public class Reverse {
	
	   public int reverse(int x) {
	        long result = 0;
	        int sign = x>0 ? 1 : -1;
	        while(x!=0) {
	            int remainder =  x % 10;
	            if(sign == 1)
	                result = result * 10 + remainder;
	            else
	                result = result*10 - remainder;
	            x = x / 10;
	        }
	        if(result>Integer.MAX_VALUE)
	            return Integer.MAX_VALUE;
	        if(result<Integer.MIN_VALUE)
	            return Integer.MIN_VALUE;
	        return (int)result*sign;
	    }
	   
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		  ListNode dummy = new ListNode(-1);
		  dummy.next = head;
		  ListNode start = dummy, end =dummy;
		  
		  while(m>1 || n>0) {
		   if(m>1) {
			   start = start.next;
			   --m;
		   }
		   if(n>0) {
			   end = end.next;
			   --n;
		   }
		  }
		  ListNode p = start.next;
		  start.next = end;
		  reverse(p, end);
		  return dummy.next;
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || head.next == null || k==1)
	   	        return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, end =dummy;
        while(end!=null) {
        	for(int i=0;i<k;i++)  {
        		end = end.next;
        		if(end==null)
        			return dummy.next;
        	}
        	ListNode nextStart = pre.next;
        	pre.next = end;
        	reverse2(nextStart,end);
        	end = nextStart;
        	pre = nextStart;
        }
        return dummy.next;
    }
	 
	private static void reverse(ListNode p, ListNode end) {
		ListNode q = p.next;
		ListNode stop = end.next;
		p.next = stop;
		while(q!=stop) {
			ListNode r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
	}	
	
	private static void reverse2(ListNode p, ListNode end) {
		ListNode q = p.next;
		ListNode stop = end.next;
		p.next = stop;
		while(q!=stop) {
			ListNode r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
	}
	
	public static void reorderList(ListNode head) {
		 if(head==null || head.next==null)
			 return;
		ListNode slow = head, fast = head;
		while(fast!=null) {
			if(fast.next != null)
				fast = fast.next.next;
			else 
				break;
			slow = slow.next;
		}
		ListNode p = slow.next;
		slow.next = null;
		//reverse the half part of the linkedlist
		p = reverse(p);
	
		while(p!=null) {
			ListNode r  = p.next;
			p.next = head.next;
			head.next = p;
			head = p.next;
			p = r;
		}
	}
	
	private static ListNode reverse(ListNode p) {
		if(p == null || p.next == null)
			return p;
		ListNode q = p.next;
		p.next = null;
		while(q!=null) {
			ListNode r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		return p;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode p = head;
		for(int i=2;i<=5;i++) {
			ListNode node = new ListNode(i);
			p.next = node ;
			p = node;
		}
		reorderList(head);
//		reverseKGroup(head, 2);
	}
	
}
