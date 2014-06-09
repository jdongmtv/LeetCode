import java.util.ArrayList;
import java.util.List;


public class RestoreIPAddress {
	
	public List<String> restoreIpAddresses(String s) {
		  if(s==null)
			  throw new NullPointerException();
		  List<String> res = new ArrayList<>();
		  dfs(res,s, 0, 0, "");
		  return res;
	}

	private void dfs(List<String> res, String s, int dot, int start, String tmp) {
		if(dot==3) {
			String ip = s.substring(start); 
			if(isValidIP(ip)) {
				res.add(tmp+ip);
				System.err.println(tmp+ip);
			}
			return;
		}
		for(int i=start;i<s.length();i++) {
			String ip = s.substring(start, i+1);
			if(isValidIP(ip)) {
				dfs(res,s, dot+1, i+1, tmp+ip+".");
			}
		}
	}
	
	private boolean isValidIP(String ip) {
		try {
			if(ip.length()>=2 && ip.charAt(0) == '0')
				return false;
			Integer ipNum = Integer.parseInt(ip);
			if(ipNum<0 || ipNum>255)
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	  
	  public static void main(String[] args) {
		  new RestoreIPAddress().restoreIpAddresses("25525511135");
	  }
	  
}
