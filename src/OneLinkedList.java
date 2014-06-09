 
public class OneLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head.next;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0) {
            int sum = carry;
            if(l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum%10);
            if(head.next == null) {
            	head.next = node;
            	tail = node;
            } else {
            	tail.next = node;
            	tail = node;
            }
            carry = sum/10;
        }
        return head.next;
    }
    
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) 
            return null;
        ListNode slow = head, fast=head.next;
        while(fast != null) {
            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
                slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
        }
        return null;
    }
    
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] result = new int[num1.length() + num2.length()];
        for(int i=0;i<num1.length();i++)
            for(int j=0;j<num2.length();j++) {
                result[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j)-'0');
            }
       int carry = 0;
       StringBuilder product = new StringBuilder();
       for(int i=0;i<result.length;i++) {
            result[i] = result[i] + carry;
            carry = result[i]/10;
            result[i] = result[i]%10;
            product.insert(0, result[i]);
        }
       return product.length()==0 ? "0" : product.toString();
    }
 
    public static void main(String[] args) {
//    	ListNode l1 = new ListNode(5);
//    	ListNode l2 = new ListNode(5);
//    	new OneLinkedList().addTwoNumbers(l1, l2);
//    	ListNode head = new ListNode(1);
//    	ListNode p = new ListNode(2);
//    	head.next = p; p.next = head;
//    	new OneLinkedList().detectCycle(head);
    	new OneLinkedList().multiply("1", "1");
    }
}
