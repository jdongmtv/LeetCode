
public class TreeDepth {
	
	public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return minDepth(root, 1);        
    }

    private int minDepth(TreeNode root, int depth)
    {
        if(root == null)
            return Integer.MAX_VALUE;

        if(root.left == null && root.right == null)
            return depth;

        int leftMinDepth = minDepth(root.left, depth+1);
        int rightMinDepth = minDepth(root.right, depth+1);

        return Math.min(leftMinDepth, rightMinDepth);
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(0);
    	new TreeDepth().minDepth(root);
    }

}
