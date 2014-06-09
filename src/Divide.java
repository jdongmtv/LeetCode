
public class Divide {

	   public int divide(int dividend, int divisor) {
		    if(dividend == 0) return 0;
	        if(divisor == 0) return (dividend > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        long a = Math.abs((long)dividend);
	        long b = Math.abs((long)divisor); 
	        int rl = 0, t = 0;
	        for(; a >= b << 1; t++) b <<= 1;
	        for(; t >= 0; t--, b >>>= 1) {    
	            if(a >= b) { 
	                a -= b;
	                rl += 1 << t;
	            }
	        }
	        return ((dividend ^ divisor) >>> 31 == 1) ? -rl : rl;
	   }
	   
	   public static void main(String[] args) {
		   int result = new Divide().divide(5,2);
		   System.err.println(result);
	   }
	   
}
