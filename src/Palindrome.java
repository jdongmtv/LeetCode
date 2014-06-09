
public class Palindrome {
	
    public String longestPalindrome(String s) {
    	if(s==null)
    		throw new NullPointerException();
        String res = "";
        for(int i=0;i<s.length();i++) {
        	String odd = expand(s,i,i);
        	String even = expand(s,i,i+1);
        	String longest = odd.length() > even.length() ? odd : even;
        	res = longest;
        }
        return res;
    }

	private String expand(String s, int i, int j) {
		while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
			--i;
			++j;
		}
		return s.substring(i+1, j);
	}
	
	public static void main(String[] args) {
		String s = "asdasdsa";
		System.err.println(s.substring(0, 1));
	}
}
