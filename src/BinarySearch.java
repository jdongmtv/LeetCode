
//search the insert position, search the range, search in a rotated sorted array.

public class BinarySearch<T extends Comparable<T>> {
	
	public int bSearch(int[] A, int target) {
		int lo = 0, hi = A.length -1;
		while(lo<=hi) {
			int mid = lo + (hi-lo)/2;
			if(A[mid] == target)
				return mid;
			else if(A[mid]>target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -1;
	}
	
   public int searchInsert(int[] A, int target) {
       int lo = 0, hi = A.length -1;
       while(lo<=hi) {
    	   int mid = lo + (hi-lo)/2;
    	   if(A[mid] == target)
    		   return mid;
    	   else if(A[mid] > target)
    		    hi = mid -1;
    	   else
    		    lo = mid + 1;
       }
       return lo;
   }
    
   public int[] searchRange(int[] A, int target) {
	   int[] res = new int[2];
	  
	   int hi = searchUpBounds(A,target);
	   int lo = searchLowBounds(A,target);
	   if(lo+1 == hi) {
		   res[0] = -1;
		   res[1] = -1;
	   } else {
		   res[0] = lo + 1;
		   res[1] = hi -1;
	   }
	   
	   return res;
   }
   
   private int searchLowBounds(int[] a, int target) {
	   int lo = 0, hi = a.length -1;
	   while(lo<=hi) {
		   int mid = lo + (hi-lo)/2;
		   if(a[mid]>=target)
			   hi = mid - 1;
		   else
			   lo = mid + 1;
	   }
	   return hi;
   }

   private int searchUpBounds(int[] a, int target) {
	   int lo = 0, hi = a.length -1;
	   while(lo<=hi) {
		   int mid = lo + (hi-lo)/2;
		   if(a[mid]<=target)
			   lo = mid + 1;
		   else
			   hi = mid - 1;
	   }
	   return lo;
   }
   
   public int search(int[] A, int target) {
	   return searchRotated(A, target);
   }
   
   private int searchRotated(int[] a, int target) {
	   int lo = 0, hi = a.length -1;
	   while(lo <= hi) {
		   int mid = lo + (hi-lo)/2;
		   if(a[mid] == target)
			   	return mid;
		   else if(a[lo] < a[mid]) { //left is ordered
			   if(a[mid]>target && a[lo]<target)  // search the left part
				   hi = mid - 1;
			   else  			 // search the right part
				   lo = mid +1;
		   } else if(a[lo] > a[mid]){  			// right is ordered
			   if(a[mid]<target && a[hi]>target)
				   lo = mid + 1;  // search the right part
			   else
				   hi = mid -1;
		   } else {
			   lo = mid + 1; // search the right part directly
		   }
	   }
	   return -1;
   }
   
   private int searchRotatedWithDuplicate(int[] a, int target, int lo, int hi) {
	   while(lo <= hi) {
		   int mid = lo + (hi-lo)/2;
		   if(a[mid] == target)
			   	return mid;
		   else if(a[lo] < a[mid]) { //left is ordered
			   if(a[mid]>target && a[lo]<=target)  // search the left part
				   hi = mid - 1;
			   else  			 // search the right part
				   lo = mid +1;
		   } else if(a[lo] > a[mid]){  			// right is ordered
			   if(a[mid]<target && a[hi]>=target)
				   lo = mid + 1;  // search the right part
			   else
				   hi = mid -1;
		   } else {
			   if(a[mid] == a[hi]) // left is equal to mid and right is also equal to mid
			   {
				   int leftResult = searchRotatedWithDuplicate(a, target, lo, mid-1);
				   return leftResult == -1 ? searchRotatedWithDuplicate(a, target, mid+1, hi) : leftResult; 
			   } else {
				   return searchRotatedWithDuplicate(a, target, mid+1, hi);
			   }
		   }
	   }
	   return -1;
   }
   
   public TreeNode buildTree(int[] inorder, int[] postorder) {
       return buildTree(inorder,0, inorder.length-1, postorder, 0, postorder.length-1);
   }
   
   private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
	   if(inStart>inEnd)
		   return null;
	   int index = -1;
	   for(int i=inStart;i<=inEnd;i++) {
		   if(inorder[i]==postorder[postEnd]) {
			   index = i;
			   break;
		   }
	   }
	   TreeNode root = new TreeNode(inorder[index]);
	   int len = index - inStart;
	   root.left = buildTree(inorder,inStart, inStart+len-1, postorder, postStart, postStart+len-1);
	   root.right = buildTree(inorder,inStart+len+1, inEnd, postorder, postStart+len, postEnd-1);
	   return root;
   }
   
//   public int bSearch(T[] a, T target) {
//	   if(a == null)
//		   throw new NullPointerException();
//	   int lo = 0 , hi = a.length -1;
//	   while(lo<=hi) {
//		   int mid = lo + (hi-lo)/2;
//		   if(a[mid].equals(target))
//			   return mid;
//		   else if(a[mid].compareTo(target))
//			   hi = mid -1;
//		   else
//			   lo = mid + 1;
//	   }
//	   return -1;
//   }
   
   public static void main(String[] args) {
	   
   }
   
}
