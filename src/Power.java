
public class Power {
	
	   public double pow(double x, int n) {
	        if(Math.abs(x)<1e-6)
	            return x;
	        return power(x, n);
	    }
	    
	    double power(double x, int n) {
	        if(n==0)
	            return 1;
	        double left = power(x,n/2);
	        if(n%2==0)
	            return left*left;
	        else {
	            if(n>0)
	                return  left*left*x;
	            else
	                return  left*left/x;
	        }
	    }
	    
	    public static void main(String[] args) {
	    	new Power().pow(8.88023, 3);
	    }
}
