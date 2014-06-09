public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }

	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBST(num, start, mid-1);
		node.right = sortedArrayToBST(num, mid+1, end);
		return node;
	}
	
   public TreeNode sortedListToBST(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		int len = 0;
		while(dummy.next!=null) {
			++len;
			dummy = dummy.next;
		}
		ListNode[] cur = new ListNode[0];
		cur[0] = head;
		return sortedListToBST(cur, 0, len-1);
	}

    private TreeNode sortedListToBST(ListNode[] cur, int start, int end) {
		 if(start>end)
			 return null;
		 int mid = (start + end)/2;
		 TreeNode left = sortedListToBST(cur, start, mid-1);
		 TreeNode root = new TreeNode(cur[0].val);
		 cur[0] = cur[0].next;
		 TreeNode right = sortedListToBST(cur, mid+1, end);
		 root.left = left;
		 root.right = right;
		 return root;
	}
    
    public int numTrees(int n) {
        if(n==0 || n==1) // tree is null or there is only one node 
        	return 1;
        int res = 0;
        for(int i=1;i<=n;i++){
            res += numTrees(i-1)*numTrees(n-i);
        }
        return res;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
		if(root == null)
			return true;
		if(root.val>maxValue || root.val<minValue)
			return false;
		return isValidBST(root.left, minValue, root.val) && isValidBST(root, root.val, maxValue); 
	} 
	
	public void recoverTree(TreeNode root) {
		TreeNode[] pre = new TreeNode[1];
		TreeNode[] mistake = new TreeNode[2];
		recoverTree(root,pre,mistake);
		int tmp = mistake[0].val;
		mistake[0].val = mistake[1].val;
		mistake[1].val = tmp;
	}
	
	private void recoverTree(TreeNode root, TreeNode[] pre, TreeNode[] mistake) {
		recoverTree(root.left,pre,mistake);
		if(pre[0]!=null && pre[0].val>root.val) {
			mistake[0] = pre[0];
			mistake[1] = root;
		}
		recoverTree(root.right,pre,mistake);
	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
        	return true;
        if((p==null && q!=null) || (p!=null && q==null))
        	return false;
        if(p.val != q.val)
        	return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public boolean isSymmetric(TreeNode root) {
    	if(root == null)
    		return true;
    	 return isSymmetric(root.left, root.right);
    }

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left==null && right==null)
			return true;
		if((left==null && right !=null) || (right==null && left!=null))
			return false;
		if(left.val != right.val)
			return false;
		return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
	}
	
	public int maxDepth(TreeNode root) {
	        if(root == null)
	            return 0;
	        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  buildTree(preorder,0, preorder.length-1, inorder, 0 , inorder.length-1);
    }

	private TreeNode buildTree(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
		if(startPre > endPre)
			return null;
		TreeNode root = new TreeNode(preorder[startPre]);
		int index = -1;
		for(int i=startIn;i<=endIn;i++)
			if(inorder[i] == preorder[startPre]) {
				index = i;
				break;
			}
		int len = index - startIn;
		root.left = buildTree(preorder, startPre+1, startPre+len, inorder, startIn, index-1);
		root.right = buildTree(preorder, startPre+len+1, endPre, inorder, index+1, endIn);
		return root;
	}
	
}
