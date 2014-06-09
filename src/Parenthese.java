import java.util.ArrayList;
import java.util.LinkedList;


public class Parenthese {

	  	public boolean isValid(String s) {
	       if(s == null || s.length() == 0)        
	            return true;
	        char[] arr = s.toCharArray();
	        LinkedList<Character> queue = new LinkedList<Character>();
	        for(int i=0; i<arr.length; i++) {
	            if(queue.isEmpty())
	                queue.add(arr[i]);
	            else if(arr[i] ==')' && queue.getLast() == '(')
	                queue.removeLast();
	            else if(arr[i] == ']' && queue.getLast() == '[')
	                queue.removeLast();
	            else if(arr[i] == '}' && queue.getLast() == '{')
	                queue.removeLast();
	            else
	                queue.addLast(arr[i]);
	        }
	        return queue.isEmpty() ? true : false;
	    }
	  
	    public ArrayList<String> generateParenthesis(int n) {
	        ArrayList<String> results = new ArrayList<String>();
	        StringBuilder result = new StringBuilder();
	        generate(results, n, n, result);
	        return results;
	    }
	    
	    public void generate(ArrayList<String> results, int left , int right , StringBuilder result) {
	        if(left==0 && right==0) {
	            results.add(result.toString());
	            return;
	        }
	        if(left>0) {
	            generate(results,  left-1, right, result.append("("));
	            result.deleteCharAt(result.length()-1);
	        }
	        if(right>left) {
	            generate(results, left, right-1, result.append(")"));
	            result.deleteCharAt(result.length()-1);
	        }
	    }
	    
	    public void generate(ArrayList<String> results, int left , int right , String result) {
	        if(left==0 && right==0) {
	            results.add(result.toString());
	            return;
	        }
	        if(left > right)
	        	return;
	        if(left>0) {
	            generate(results,  left-1, right, result+"(");
	        }
	        if(right>0) {
	            generate(results, left, right-1, result+")");
	        }
	    }
	    
	    public static void main(String[] args) {
	    	new Parenthese().generateParenthesis(1);
	    }
}
