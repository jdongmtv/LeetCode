import java.util.ArrayList;
import java.util.Stack;


public class TreeStack {

	   public ArrayList<Integer> preorderTraversal(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(root == null)
	            return result;
	        TreeNode  p = root;
	        while(!stack.isEmpty() || p!=null ) {
	            while(p!= null) {
	                result.add(p.val);
	                stack.push(p);
	                p = p.left;
	            }
	            p = stack.pop();
	            p = p.right;
	        }
	        return result;
	   }
	   
	   public ArrayList<Integer> inorderTraversal(TreeNode root) {
       	Stack<TreeNode> stack = new Stack<TreeNode>();
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        if(root == null)
	            return result;
	        TreeNode  p = root;
	        while(!stack.isEmpty() || p!=null ) {
	            while(p!= null) {
	                stack.push(p);
	                p = p.left;
	            }
	            p = stack.pop();
	            result.add(p.val);
	            p = p.right;
	        }
	        return result;
	   }
	   
}
