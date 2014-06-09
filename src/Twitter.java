
public class Twitter {
	
	public  static String countAndSay(int n) {
		if(n<=0)
			return "";
		String result = "1";
		StringBuilder tmp = new StringBuilder();
		for(int i=1;i<n;i++) {
			for(int j=0;j<result.length();j++) {
				int count = 1;
				while(j+1<result.length() && result.charAt(j)==result.charAt(j+1)) {
					++count;
					++j;
				}
				tmp.append(count).append(result.charAt(j));
			}
			result = tmp.toString();
			tmp.delete(0, tmp.length());
		}
		return result;
	}
	
}
