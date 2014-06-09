
public class RemoveDuplicat {

    public int removeDuplicates(int[] A) {
        if(A==null || A.length == 0)  
              return 0;
        int cur = 0, start = 0, repeat = 0;
        while(cur<A.length) {
            if(A[cur]==A[start]) {
              if(repeat==1)
                 A[start++] = A[cur++];
              else 
                  cur++;
              repeat++;
            } else  {
              repeat = 1;
              A[++start] = A[cur++];
            }
        }
        return start+1;
     }
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null)  
          return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next  = head;
        ListNode pre = dummyHead, p = head;
        while(p!=null&&p.next!=null) {
              if(p.val == p.next.val) {
                   ListNode q = p.next.next;
                   while(q!=null && q.val== p.val) {
                        q = q.next;
                   }
                   pre.next = q;
                   p = q;
              } else {
                  pre = p;
                  p = p.next;
              }
        }
        return dummyHead.next;
     }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre =dummyHead, p=head, q=head;
        for(int i=0;i<n;i++)
            q = q.next;
        while(q!=null) {
            q = q.next;
            pre = p;
            p = p.next;
        }
        pre.next = p.next;
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
    	int[] A = {1,1,1,1,3,3};
    	new RemoveDuplicat().removeDuplicates(A);
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(1);
    	new RemoveDuplicat().deleteDuplicates(head);
    }
    
}
