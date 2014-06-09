import java.util.Stack;


public class Solution {
	
	static class MinStack extends Stack<Integer> {
		Stack<Integer> minStack = new Stack<>();
		private static final long serialVersionUID = 1L;
		MinStack() {
			super();
		}
		@Override
		public Integer push(Integer item) {
			   if(minStack.isEmpty())
			          minStack.push(item);
			        else  {
			          if(item < minStack.peek())
			        	  minStack.push(item);
			          else
			        	  minStack.push(minStack.peek());
			        }
			return super.push(item);
		}
		
		@Override
		public synchronized Integer pop() {
			minStack.pop();
			return super.pop();
		}
		@Override
		public synchronized Integer peek() {
			Integer res = super.peek();
			System.err.println(res);
			return res;
		}
		
		Integer minpeek() {
			Integer res = minStack.peek();
			System.err.println(res);
			return res;
		}
	}
	
	 public static void main(String[] args) {
		 MinStack stack = new MinStack();
		    stack.push(8);
		    stack.push(4);
		    stack.push(6);
		    stack.push(2);
		    stack.push(9);
		    stack.peek(); 
		    stack.minpeek(); 
		    stack.pop();
		    stack.pop();
		    stack.peek(); 
		    stack.minpeek();
	 }
}
