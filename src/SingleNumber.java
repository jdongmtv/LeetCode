import java.util.ArrayList;


public class SingleNumber {
	
	   public int singleNumber(int[] A) {
	        if(A==null || A.length == 0)
	            return 0;
	        int result = 0;
	        for(int i=0; i<32;i++) {
	            int bit = 0;
	            for(int j=0;j<A.length;j++) {
	            	if(((A[j]>>i)&1) > 0)
	                bit = (bit + 1)%3;
	            }
	            result= result | (bit<<i);
	        }
	        return result;
	    }
	   
	   public static void main(String[] args) {
		   int[] A = {2,2,3,2};
		   int result = new SingleNumber().singleNumber(A);
		   System.err.println(result);
		   ArrayList<Integer> arrayList = new ArrayList<Integer>();
	   }
	   
}
