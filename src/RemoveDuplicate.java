
public class RemoveDuplicate {
	
	public ListNode deleteDuplicates(ListNode head) {
	    if(head == null)
	        return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = head, p = head.next;
		while(p!=null) {
			if(pre.val == p.val)
				 p = p.next;
			else {
				pre.next = p;
				pre = p;
				p = p.next;
			}
		}
		pre.next = null;
		return dummy.next;
	}
	
	public ListNode deleteDuplicates2(ListNode head) {
		if(head == null || head.next == null)
		 	return head;
		 ListNode dummy = new ListNode(-1);
		 dummy.next = head;
		 ListNode pre = dummy;
		 while(pre.next!= null) {
		 	ListNode q  = pre.next;
		 	if(q.next !=null && q.val == q.next.val) {
		 		int val = q.val;
		 		ListNode tmp = q.next;
		 		while(tmp!=null && tmp.val == val)
		 			tmp = tmp.next;
		 		pre.next = tmp;
		 	} else {
		 		pre.next = q;
		 		pre = q;
		 	}
		 }
		return dummy.next;
	}
	
	public static int removeDuplicates3(int[] A) {
		if(A==null)
			throw new NullPointerException();
		if(A.length<=1)
			return A.length;
		int start = 1;
		int cur = 1;
		int count = 1;
		while(cur<A.length) {
			if(count<2) {
				if(A[cur-1]==A[cur])
					++count;
				else
					count = 1;
				A[start++] = A[cur++];
			} else {
				while(cur<A.length && A[cur]==A[cur-1])
					cur++;
				count = 1;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,1};
		removeDuplicates3(A);
	}
}
