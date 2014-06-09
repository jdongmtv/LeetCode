import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PostOrder {
	
	 public List<Integer> postorderTraversal(TreeNode root) {
		 if(root == null)
			 throw new NullPointerException();
		 List<Integer> res = new ArrayList<>();
		 Stack<TreeNode> first = new Stack<>();
		 Stack<TreeNode> second = new Stack<>();
		 first.add(root);
		 while(!first.isEmpty()) {
			 TreeNode treeNode  = first.pop();
			 second.add(treeNode);
			 if(treeNode.left != null)
				 first.add(treeNode.left);
			 if(treeNode.right != null)
				 first.add(treeNode.right);
		 }
		 while(!second.isEmpty()) {
			 res.add(second.pop().val);
		 }
		 return res;
	 }
	 
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(!stack.isEmpty() || p != null) {
			while(p!=null) {
				stack.add(p);
				res.add(p.val);
				p = p.left;
			}
			p = stack.pop();
			p = p.right;
		}
		return res;
	}
	
    public int sumNumbers(TreeNode root) {
       int[] sum = new int[1];
       sumNumbers(root, 0, sum);
       return sum[0];
    }

	private void sumNumbers(TreeNode root, int result, int[] sum) {
		if(root == null)
			return;
		result = result*10 + root.val;
		if(root.left == null || root.right == null)
			sum[0]+=result;
		sumNumbers(root.left, result, sum);
		sumNumbers(root.right, result, sum);
	}
	
	public int maxPathSum(TreeNode root) {
		 int[] res = new int[1];
		 res[0] = Integer.MIN_VALUE;
		 getPathSum(root, res);
		 return res[0];
	}

	private int getPathSum(TreeNode root, int[] res) {
		if(root == null)
			return 0;
		int left = getPathSum(root.left,   res);
		int right = getPathSum(root.right, res);
		int arch = root.val + left + right;
		int single = Math.max(root.val,Math.max(root.val+left, root.val + right));
		res[0] = Math.max(res[0], Math.max(single, arch));
		return single;
	}
	
	public void flatten(TreeNode root) {
	     TreeNode[] pre = new TreeNode[1]; 
	     flatten(root, pre);
	}

	private void flatten(TreeNode root, TreeNode[] pre) {
		TreeNode left = root.left;
		TreeNode right = root.right;
		if(pre[0] != null) {
			pre[0].right = root;
		}
		root.left = null;
		pre[0] = root;
		flatten(left, pre);
		flatten(right,pre);
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
	    return hasPathSum(root, sum, 0);
	}

	private boolean hasPathSum(TreeNode root, int sum, int result) {
		if(root == null)
			return false;
		result = result + root.val;
		if(root.left == null && root.right == null && result == sum)
			return true;
		boolean hasfound = hasPathSum(root.left, sum, result);
		if(hasfound)
			return true;
		else
			return hasPathSum(root.right, sum,result);
	}
	
}
