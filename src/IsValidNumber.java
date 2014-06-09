
public class IsValidNumber {
	
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;
        String[] tmp = s.split("e");
        if(tmp.length>2 || tmp.length<=0)
            return false;
        if(tmp.length==1)
            return isValid(tmp[0],false);
        else 
            return isValid(tmp[0],false) && isValid(tmp[1],true);
    }
    
    private boolean isValid(String s, boolean hasDot) {
        if(s.length()==0)
            return false;
        boolean dot = hasDot;
        if(s.charAt(0)=='+' || s.charAt(0)=='-') 
            s = s.substring(1);
        for(int i=0; i<s.length();i++) {
            if(s.charAt(i)=='.') {
                if(dot)
                    return false;
                else 
                    dot = true;
            } else if(s.charAt(i)<0 || s.charAt(i)>9)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	new IsValidNumber().isNumber("3");
    }
    
}
