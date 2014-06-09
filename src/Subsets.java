import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		results.add(new ArrayList<Integer>());
		if (S == null || S.length == 0)
			return results;
		Arrays.sort(S);
		for (int i = 1; i <= S.length; i++) {
			dfs(results, new ArrayList<Integer>(), i, 0, S);
		}
		return results;
	}

	public void dfs(ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> result, int num, int start, int[] S) {
		if (num == 0) {
			ArrayList<Integer> tmp = (ArrayList<Integer>) result.clone();
			results.add(tmp);
		}
		for (int i = start; i < S.length; i++) {
			result.add(S[i]);
			dfs(results, result, num - 1, i + 1, S);
			result.remove(result.size() - 1);
			while (i < S.length - 1 && S[i] == S[i + 1])
				i++;
		}
	}
	    
	public static void main(String[] args) {
		int[] S = {0};
		new Subsets().subsetsWithDup(S);
	}
	
}
