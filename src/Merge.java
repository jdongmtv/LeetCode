import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Merge {

    public void merge(int A[], int m, int B[], int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i>=0 && j>=0) {
            if(A[i]>B[j]) 
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        while(j>=0)
          A[k--] = B[j--];
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if(lists == null || lists.size() == 0)
    			return null;
    	int size = lists.size();
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
        	@Override
        	public int compare(ListNode o1, ListNode o2) {
        		return o1.val - o2.val;
        	}
		});
        ListNode head = null, p = null;
        for(int i=0;i<size;i++) {
            if(lists.get(i) != null)
            	heap.add(lists.get(i));
        }
        while(!heap.isEmpty()) {
        	ListNode node = heap.poll();
        	if(node.next != null)
        		heap.add(node.next);
        	if(head == null) {
        		head = node;
        		p = node ;
        	} else {
        		p.next = node;
        		p = node;
        	}
        }
        return head;
    }
    
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)
            return 0;
        String[] tmp = s.split(" ");
        int i=tmp.length-1;
        for(;i>=0;i--)
            if(!tmp[i].equals(""))
                break;
        return i<0 ? 0 : tmp[i].length();
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null) cur.next = l1;
        else cur.next = l2;
        return dummy.next;
    }
    
    public static void main(String[] args) {
    	int[] A = {2,0};
    	int[] B = {1};
    	new Merge().merge(A,1,B,1);
    	ArrayList<ListNode> lists = new ArrayList<ListNode>();
    	new Merge().mergeKLists(lists);
    	new Merge().lengthOfLastWord("day");
    }
    
}
