import java.util.LinkedList;


public class ReversePolishExpression {
	
	   public int evalRPN(String[] tokens) {
	        if(tokens==null ||tokens.length==0)
	            return 0;
	        LinkedList<String> stack = new LinkedList<String>();
	        for(int i=0;i<tokens.length;i++) {
	            if(tokens[i].equals("+")) {
	                int op2 = Integer.parseInt(stack.removeLast());
	                int op1 = Integer.parseInt(stack.removeLast());
	                int result = op1 + op2;
	                stack.addLast(""+result);
	            } else if(tokens[i].equals("-")) {
	                int op2 = Integer.parseInt(stack.removeLast());
	                int op1 = Integer.parseInt(stack.removeLast());
	                int result = op1-op2;
	                stack.addLast(""+result);
	            } else if(tokens[i].equals("*")) {
	                int op2 = Integer.parseInt(stack.removeLast());
	                int op1 = Integer.parseInt(stack.removeLast());
	                int result = op1*op2;
	                stack.addLast(""+result);
	            } else if(tokens[i].equals("/")) {
	                int op2 = Integer.parseInt(stack.removeLast());
	                int op1 = Integer.parseInt(stack.removeLast());
	                int result = op1/op2;
	                stack.addLast(""+result);
	            } else {
	                stack.addLast(tokens[i]);
	            }
	        }
	        return Integer.parseInt(stack.removeLast());
	    }
	   
	public static void main(String[] args) {
		String[] tokens = {"0","3","/"};
		new ReversePolishExpression().evalRPN(tokens);
	}
}
