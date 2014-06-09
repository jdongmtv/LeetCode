import java.util.ArrayList;


public class Combination {
	
	static void combinate(int a[], int k, int start, ArrayList<Integer> result) {
		if(result.size() == k) {
			for(Integer integer : result) {
				System.err.print(integer);
			}
			System.err.println();
		}
		for(int i=start;i<a.length;i++) {
			result.add(a[i]);
			combinate(a, k, i+1, result);
			result.remove(result.size()-1);
			while(i+1<a.length && a[i] == a[i+1])
				++i;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {1,1,2,2,3,4};
		Combination.combinate(a, 3, 0, new ArrayList<Integer>());
	}
}
