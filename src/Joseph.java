
public class Joseph {
	
	public static void main(String[] args) {
		for(int i=1;i<=100;i++) {
			System.err.println(i + ":" + caculate(i) );
		}
	}
	
	private static int caculate(int n) {
		int lo = 0 ,hi = 0;
		for(int i = 1; i < n; ++i) {
			lo = hi;
			hi = (1+lo)%i+1 ;
		}
		return hi+1;
	}
}
