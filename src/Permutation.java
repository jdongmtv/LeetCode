import java.util.Arrays;


public class Permutation {
	static int count;
	
	static void permute(int[] arr, int start) {
		if(start==arr.length) {
//			for(int ele : arr)
//				System.err.print(ele);
//			System.err.println();
			++count;
		}
		for(int i = start; i<arr.length; i++ ) {
			int tmp = arr[i];
			arr[i] = arr[start];
			arr[start] = tmp;
			
			permute(arr, start+1);
			
			tmp = arr[i];
			arr[i] = arr[start];
			arr[start] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		Permutation.permute(arr, 0);
		System.err.println(count);
		String s[] = {"cat", "star", "act", "god", "arts", "dog", "rats"};
		Arrays.sort(s);
		for(String tmp : s) {
			System.err.print(tmp + " ");
		}
		System.err.println();
	}
	
}
