import java.util.ArrayList;
import java.util.List;


public class Parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, n, "");
        return result;
    }

	private void generate(List<String> result, int left, int right, String tmp) {
		if(left==0 && right==0) {
			result.add(tmp);
		}
		if(left>right)
			return;
		if(left>0)
			generate(result, left-1, right, tmp+"(");
		if(right>0)
			generate(result, left, right-1, tmp+")");
	}
}
