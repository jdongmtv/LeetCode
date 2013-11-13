import java.util.HashSet;
import java.util.Set;


public class WordBreak {
	
	private static boolean result = false;
	
	public boolean wordBreak(String s, Set<String> dict) {
		  result = false;
		  dfs(s,dict,0);
		  return result;
	}

	private static void dfs(String s, Set<String> dict, int start) {
		if(result == true) {
			System.err.println("the result is: " + result);
			return;
		}
		if(dict.size()==0 && start == s.length())
			result =  true;
		for(int i = start; i< s.length(); i++) {
			String tmp = s.substring(start, i);
			if(dict.contains(tmp)) {
				dict.remove(tmp);
				dfs(s,dict,i+1);
				dict.add(tmp);
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] data = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> dict = new HashSet<String>();
		for(String string :data ) {
			dict.add(string);
		}
		dfs(s,dict,0);
	}
}
