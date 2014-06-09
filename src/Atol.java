
public class Atol {
	
	static long stringToLong(String s) {
		if(s == null)
			throw new NullPointerException();
		
		s = s.trim();
		int sign = 1;
		long result = 0;
		
		for(int i=0;i<s.length();i++) {
			// get sign 
			if(i==0&&(s.charAt(i)=='+' || s.charAt(i)=='-')) {
				if(s.charAt(i)== '-')
					sign = -1;
				continue;
			}
			//illegal character break or throws a exception if necessary
			if(s.charAt(i)<'0' || s.charAt(i)>'9')
					break;
			else {
				if((result > Long.MAX_VALUE/10 || (result == Long.MAX_VALUE/10 && s.charAt(i) - '0' > Long.MAX_VALUE%10)) 
				   && sign == 1)
					return Long.MAX_VALUE;
				else if((result*sign < Long.MIN_VALUE/10 || (result*sign == Long.MIN_VALUE/10 && s.charAt(i)-'0' > -1*(Long.MIN_VALUE%10))) 
						&& sign == -1)
					return Long.MIN_VALUE;
				result = result*10 + s.charAt(i)-'0';
			}
		}
		
		return result*sign;
	}
	
	public static void main(String[] args) {
		System.err.println(Atol.stringToLong("9999999999999999999999999999999999999999999999999999"));
		System.err.println(Atol.stringToLong("-999999999999999999999999999999999999999999999999999"));
		System.err.println(Atol.stringToLong("12309783"));
		System.err.println(Atol.stringToLong("-879654327891"));
		System.err.println(Atol.stringToLong("9223372036854775809"));
		System.err.println(Atol.stringToLong("-9223372036854775809"));
		System.err.println(Atol.stringToLong("-9223372036854775801"));
	}
	
}
