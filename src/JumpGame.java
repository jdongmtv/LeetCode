
public class JumpGame {
	
	public boolean canJump(int[] A) {
		 int maxIndex = 0;
		 for(int i=0;i<A.length;i++) {
			 if(i>maxIndex)
				 return false;
			 maxIndex = Math.max(maxIndex, i+A[i]);
			 if(maxIndex>=A.length-1)
				 break;
		 }
			 return false;
	}
	
	public int jump(int[] A) {
		if(A==null || A.length==0)
			return 0;
		int size = A.length;
		int start=0 ,end=0, max=0,step=0;
		while(end<size) {
			while(start<=end) {
				max = Math.max(max, start+A[start]);
				if(max>=size-1)
					return step+1;
				++start;
			}
			start = end +1;
			end = max;
			++step;
		}
		return step;
	}
	
	public static String minWindow(String S, String T) {
		
		int[] needToFind = new int[256];
		int[] hasFind = new int[256];
		int minlen = Integer.MAX_VALUE;
		String res = "";
		int start = 0, end =0,count=0;
		for(int i=0;i<T.length();i++) {
			char index = T.charAt(i);
			++needToFind[index];
		}
		
		for(;end<S.length();end++) {
			char cur = S.charAt(end);
			if(needToFind[cur] ==0 ) 
				continue;
			++hasFind[cur];
			if(hasFind[cur]<=needToFind[cur])
				++count;
			if(count == T.length()) {
				char startChar = S.charAt(start);
				while(needToFind[startChar]==0 || hasFind[startChar] > needToFind[startChar]) {
					++start;
					if(hasFind[startChar] > needToFind[startChar])
						--hasFind[startChar];
					startChar = S.charAt(start);
				}
				int len = end - start +1;
				if(len<minlen) {
					minlen = len;
					res = S.substring(start, end+1);
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		minWindow("a", "aa");
	}
	
}
