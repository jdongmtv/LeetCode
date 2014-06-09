import java.util.ArrayList;
import java.util.List;


public class PhoneNumber {
	
      String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
     
	  public List<String> letterCombinations(String digits) {
	        List<String> res = new ArrayList<>();
	        dfs(res,0, "", digits);
	        return res;
	    }

	  private void dfs(List<String> res, int i, String tmp, String digits) {
		  if(i == digits.length()) {
			  res.add(tmp);
			  System.err.print(tmp + "\t");
			  return;
		  }
		  String chosen = map[digits.charAt(i)-'2'];
		  for(int j=0;j<chosen.length();j++) {
			    dfs(res, i+1, tmp+chosen.charAt(j), digits);
		  }
	  }
	  
	  public static void main(String[] args) {
		  new PhoneNumber().letterCombinations("23");
	  }
}
