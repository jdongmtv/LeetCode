
public class Add {

    public String addBinary(String a, String b) {
        if(a==null) return b;
        else if(b==null) return a;
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>=0 || j>=0 || carry!=0) {
            int sum = carry;
            if(i>=0) {
                sum = sum  + a.charAt(i) - '0';
                --i;
            } 
            if(j>=0) {
                sum = sum  + b.charAt(j) - '0';
                --j;
            }
            result.append(""+sum%2);
            carry = sum/2;
        }
        return result.reverse().toString();
    }
    
    public static void main(String[] args) {
    	new Add().addBinary("0","0");
    	String test = "1:::::2::::3::::4::::";
    	String[] tmp = test.split(":");
    	for(String s : tmp) {
    		if(!s.equals(""))
    			System.err.println(s);
    	}
    	System.err.println(tmp.length);
    }
}
