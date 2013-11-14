
public class RotateImage {
	
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0 ; layer < n/2; layer++)
            for(int j = 0; j < n - 1 -2*layer; j++) {
                int offset = n - layer -1;
                
                //save the top
                int save  = matrix[layer][layer+j];
                System.err.println("the top is : " + matrix[layer][layer+j]);
                
                // left to top
                matrix[layer][layer+j] = matrix[offset-j][layer];
                System.err.println("the left is : " + matrix[offset-j][layer]);
                
                // bottom to left 
                matrix[offset-j][layer] = matrix[offset][offset-j];
                System.err.println("the bottom is : " + matrix[offset][offset-j]);
                
                //right to bottom
                matrix[offset][offset-j] = matrix[layer+j][offset];
                System.err.println("the right is : " +  matrix[layer+j][offset]);
                
                //top to right
                matrix[layer+j][offset] = save;
            }
    }
    
    public static void main(String[] args) {
//    	int[][] matrix1 = {{1}};
    	int[][] matrix2 = {{1,2},{3,4}};
    	rotate(matrix2);
    	for(int i=0; i<matrix2.length; i++) {
    		for(int j=0; j<matrix2[i].length; j++) {
    			System.err.print(matrix2[i][j] + "\t");
    		}
    		System.err.println();
    	}
    }
}
