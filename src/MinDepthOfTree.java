
public class MinDepthOfTree {
	
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
        	return 1;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(l==0)
        	return r+1;
        if(r==0)
        	return l+1;
        return Math.min(l, r) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if(Math.abs(l-r)>1)
        	return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode root) {
    	if(root == null)
    		return 0;
    	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
