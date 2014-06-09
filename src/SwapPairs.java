
public class SwapPairs {
	
	 public ListNode swapPairs(ListNode head) {
	       ListNode dummy = new ListNode(-1);
	       dummy.next = head;
	       ListNode p = dummy;
	       while(p.next!=null) {
	       	ListNode q = p.next;
	       	ListNode r = q.next;
	       	if(r != null) { 
	       		p.next = r;
	       		q.next = r.next;
	       		r.next = q;
	       	} 	
	       	p = q;
	       }
	       return dummy.next;
	 }
	 
	public ListNode removeNthFromEnd(ListNode head, int n) {
	      ListNode dummy = new ListNode(-1);
	      dummy.next = head;
	      ListNode p=dummy, q=dummy;
	      while(--n>=0) {
	      	q = q.next;
	      }
	      while(q.next != null) {
	      	p = p.next;
	      	q = q.next;
	      }
	      p.next = p.next.next;
	      return dummy.next;
	}
	  
	public int removeDuplicates(int[] A) {
		int start = 0, end = A.length-1;
		int cur = start;
		while(true) {
			while(cur<end && A[cur]==A[cur+1])
				++cur;
			if(cur>end)
			    break;
			A[start++] = A[cur++];
		}
		return start;
	}
	
	public int removeElement(int[] A, int elem) {
	        int start = 0, end = A.length - 1;
			int cur = 0;
			while(cur<=end) {
				if(A[cur] == elem)
					++cur;
				else
					A[start++] = A[cur++];
			}
			return start;
	}
	
	public String reverseWords(String s) {
	       StringBuilder res = new StringBuilder();
	       String[] tmp = s.split(" ");
	       for(int i=tmp.length-1; i>=0; i--) {
	    	    if(tmp[i].length()!=0)
	    	    	res.append(tmp[i]).append(" ");
	       }
	       if(res.length()>0)
	    	   res.deleteCharAt(res.length()-1);
	       return res.toString();
	}
	
	public String addBinary(String a, String b) {
		if(a==null)
			return b;
		else if(b==null)
			return a;
		int carry=0, i=a.length()-1, j = b.length() -1;
		StringBuilder res = new StringBuilder();
		while(carry>0 || i>=0 || j>=0) {
			int sum = carry;
			if(i>=0) {
				sum = sum + a.charAt(i) - '0';
			}
			if(j>=0) {
				sum = sum + b.charAt(j) - '0';
			}
			res.append(sum%2);
			carry = sum/2;
		}
		return res.reverse().toString();
	}
	
    public void merge(int A[], int m, int B[], int n) {
      	int i = m -1 , j = n-1, k = m+n-1;
    	while(i>=0 && j>=0) {
    		if(A[i]>B[j]) {
    			A[k--] = A[i--];
    		} else {
    			A[k--] = B[j--];
    		}
    	}
    	while(i>=0)
    		A[k--] = A[i--];
    	while(j>=0)
    		A[k--] = B[j--];
    }
    
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    
	private ListNode sortList(ListNode head, Object object) {
		return null;
	}
	
	
}
	