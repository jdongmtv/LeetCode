import java.util.ArrayList;
import java.util.List;


public class Matrix {
	
	 public List<Integer> spiralOrder(int[][] matrix) {
		   List<Integer> res = new ArrayList<>();
		   if(matrix==null ||matrix.length==0)
			   return res;
	
	      int m = matrix.length;
	      int n = matrix[0].length;
	      int left = 0, right = n-1;
	      int top = 0, bottom = m-1;
	      while(true) {
	   	   for(int i=left;i<=right;i++) { 
	   		   res.add(matrix[top][i]);
	   	   }
	   	   if(++top>bottom) break;
	   	   
	   	   for(int i=top;i<=bottom;i++)  {
	   		   res.add(matrix[i][right]);
	   	   }
	   	   if(--right<left) break;
	   	   
	   	   for(int i=right;i>=left;i--)  {
	   		    res.add(matrix[bottom][i]);
	   	   }
	   	   if(--bottom<top) break;
	   	   
	   	   for(int i=bottom;i>=top;i--)  {
	  		    	res.add(matrix[i][left]);
	   	   }
	   	   if(++left>right) break;
	      }
	      return res;
	 }
	  
	 public int[][] generateMatrix(int n) {
		 	if(n<=0)
		 		return null;
	        int[][] res = new int[n][n];
	        int left = 0, right = n-1;
		    int top = 0, bottom = n-1;
		    int count = 1;
		    while(true) {
		   	  for(int i=left;i<=right;i++) { 
		   	   res[top][i] = count++;
		   	  }
		   	  if(++top>bottom) break;
		   	  
		   	  for(int i=top;i<=bottom;i++)  {
		   	   res[i][right] = count++;
		   	  }
		   	  if(--right<left) break;
		   	  
		   	  for(int i=right;i>=left;i--)  {
		   	    res[bottom][i] = count++;
		   	  }
		   	  if(--bottom<top) break;
		   	  
		   	  for(int i=bottom;i>=top;i--)  {
		   	   	res[i][left] = count++;
		   	  }
		   	  if(++left>right) break;
		    }
		    return res;       
	 }
	 
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix == null || matrix.length == 0)
			 return false;
		 int m = matrix.length, n = matrix[0].length;
		 int i = 0, j = n-1;
		 while(i<m && j>=0) {
			 if(matrix[i][j] == target)
				 return true;
			 else if(matrix[i][j] > target)
				 --i;
			 else
				 ++j;
		 }
		 return false;
	 }
	 
	 public void setZeroes(int[][] matrix) {
		 if(matrix == null || matrix.length == 0)
			 return;
		 int row = -1, col = -1;
		 for(int i = 0; i < matrix.length; i++)
			 for(int j = 0; j < matrix[0].length; j++) {
				 if(matrix[i][j] == 0) {
					 if(i==0) 
						 row = 0;
					 else
						 matrix[0][j] = 0;
					 
					 if(j==0) 
						 col = 0;
					 else
						 matrix[i][0] = 0;
				 }
			 }
		 for(int i=1;i<matrix.length;i++) {
			 if(matrix[i][0] == 0) {
				 for(int j=1;j<matrix[0].length;j++)
					 matrix[i][j] = 0;
			 }
		 }
		 for(int i=1;i<matrix[0].length;i++) {
			 if(matrix[0][i] == 0) {
				 for(int j=1;j<matrix.length;j++)
					 matrix[j][i] = 0;
			 }
		 }
		 if(row==0) {
			 for(int i=0;i<matrix[0].length;i++)
				 matrix[0][i] = 0;
		 }
		 if(col==0) {
			 for(int i=0;i<matrix.length;i++)
				 matrix[i][0] = 0;
		 }
	 }
	 
	public void rotate(int[][] matrix) {
	     if(matrix == null || matrix.length == 0)
	    	 return;
	     int n = matrix.length;
	     for(int layer=0;layer<n/2;layer++)
	    	 for(int i=layer;i<n-layer-1;i++) {  // i already contains the layer
	    		 int top = matrix[layer][i]; // preserve the top
	    		 matrix[layer][i] =   matrix[n-i-1][layer];       // from left to top 
	    		 matrix[n-i-1][layer] = matrix[n-1-layer][n-i-1]; // from bottom to left
	    		 matrix[n-1-layer][n-i-1] = matrix[i][n-1-layer]; //from right to bottom
	    		 matrix[i][n-1-layer] = top;  //from top to right
	    	 }
	}
	
	public static void main(String[] args) {
		 int[][] matrix = {{1}};
		 new Matrix().spiralOrder(matrix);
		 int n=1 , m=3;
		 caculateRepeat(n,m);
	}

	private static void caculateRepeat(int n, int m) {
		int repeat = 1;
		while(n<m){
			n = n*10;
		}
		int remainder = n%m;
		while(n*10%m != remainder) {
			n = n*10;
			++repeat;
		}
		System.err.println(n/m);
		System.err.println(repeat);
	}
	
}
