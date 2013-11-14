
public class InsertionSortList {
    
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head.next,pre = head;
        while(p!=null) {
            ListNode q = findPos(head,p);
            if(q == pre) {
                pre = p;
                p = p.next;
            } else if(q == null) {
                pre.next = p.next;
                p.next = head;
                head = p;
                p = pre.next;
            } else {
                pre.next = p.next;
                p.next = q.next;
                q.next = p;
                p = pre.next;
            }
        }
        return head;
    }
    
    private static ListNode findPos(ListNode head, ListNode p) {
        if(head.val>=p.val)
            return null;
        ListNode q = head, pre = q;
        while(q != p && q.val< p.val) {
        	pre = q;
            q = q.next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
    	ListNode p = head;
    	p.next = new ListNode(4);
    	p = p.next;
    	p.next = new ListNode(1);
    	p = p.next;
//    	p.next = new ListNode(3);
//    	p = p.next;
    	
    	insertionSortList(head);
    }
}
