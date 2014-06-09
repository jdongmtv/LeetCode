
public class Atoi {
	
    public static int atoi(String str) {
        if(str == null)
            throw new NullPointerException();
        str = str.trim();
        int result = 0;
        int sign = 1;
        for(int i=0; i<str.length();i++) {
            if(i==0 && (str.charAt(i)=='+' || str.charAt(i)=='-')) {
                if(str.charAt(i)=='-')
                    sign = -1;
                continue;
            }
            if(str.charAt(i)<'0' || str.charAt(i)>'9')
            	break;
            if((result>Integer.MAX_VALUE/10)||(result == Integer.MAX_VALUE/10 && str.charAt(i)-'0' > Integer.MAX_VALUE%10)
            	&& sign == 1)
            	return Integer.MAX_VALUE;
            else if(result> -1*(Integer.MIN_VALUE/10) || (result*sign == Integer.MIN_VALUE/10 && str.charAt(i)-'0' > -1 *(Integer.MIN_VALUE%10))
            		&& sign == -1) 
            	return Integer.MIN_VALUE;
            result = result*10 + str.charAt(i) - '0';
        }
        return result*sign;
    }
    
    public static void main(String[] args) {
    	Atoi.atoi("      -11919730356x");
    }
}
