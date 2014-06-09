
public class CountAndSay {
	   public String countAndSay(int n) {
	        if(n <= 0)
	            return null;
	        String result = "1";
	        StringBuilder sb = new StringBuilder();
	        while(--n>0) {
	            for(int i=0;i<result.length();i++) {
	                int count = 1;
	                while(i+1<result.length() && result.charAt(i) == result.charAt(i+1)) {
	                	++i;
	                	++count;
	                }
	                sb.append(count).append(result.charAt(i));
	            }
	            result = sb.toString();
	            sb.delete(0, sb.length());
	        }
	        return result;
	    }
	   
	   public static void main(String[] args) {
		   CountAndSay instance = new CountAndSay();
		   for(int i=1;i<=10;i++) {
			   String result = instance.countAndSay(i);
			   System.err.println(result);
		   }
	   }
}
