
public class BST {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		if (root.val >= max || root.val <= min)
			return false;
		return isValidBST(root.left, min, root.val)
				&& isValidBST(root.right, root.val, max);
	}
	 
	 public void recoverTree(TreeNode root) {
	    TreeNode p1 = null, p2 = null;
	    findNode(root, p1, p2, null);
	    if(p1!=null && p2!=null) {
	        p1.val = p1.val^p2.val;
	        p2.val = p1.val^p2.val;
	        p1.val = p1.val^p2.val;
	    }
	  }
	    
	 private void findNode(TreeNode root, TreeNode p1, TreeNode p2, TreeNode pre) {
	        if(root!=null) {
	            findNode(root.left, p1, p2, pre);
	            if(pre!=null && pre.val>root.val) {
	                p1 = pre;
	                p2 = root;
	            }
	            pre = root;
	            findNode(root.right, p1, p2, pre);
	        }
	    }
	    
	  public static void main(String[] args) {
		  TreeNode root = new TreeNode(0);
		  root.left = new TreeNode(1);
		  new BST().isValidBST(root);
		  new BST().recoverTree(root);
	  }
	  
}
