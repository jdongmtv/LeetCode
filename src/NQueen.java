import java.util.ArrayList;


public class NQueen {

    private int cnt;
	private int upper;

	public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> results = new ArrayList<String[]>();
    	int[] arr = new int[n];
    	dfs(0,n,results,arr);
    	return results;
    }

	private void dfs(int i, int n, ArrayList<String[]> results, int[] arr) {
		if(i==n) {
			String[] result = new String[n];
			for(int j=0; j<n; j++) {
				String tmp="";
				for(int k=0;k<n;k++){
					if(arr[j]==k)
						tmp = tmp +"Q";
					else
						tmp = tmp +".";
				}
				result[j] = tmp;
			}
			results.add(result);
		}
		for(int col=0;col<n;col++)
			if(isLegal(arr,i,col)) {
				arr[i] = col;
				dfs(i+1, n, results, arr);
			}
	}

	private boolean isLegal(int[] arr, int row, int col) {
		for(int i=0;i<row;i++) {
			if(arr[i]==col || Math.abs(arr[i]-col)==Math.abs(row-i))
				return false;
		}
		return true;
	}
	
	public int totalNQueens(int n){
        cnt = 0;
        upper = (1<<n)-1 ;
        Queen(0,0,0);
        return cnt;
    }
    
    //为啥说大牛niub呢，看看我下面那个，再对比ld和rd，人大牛一眼就看出来了，没必要保存
    //所有对角线信息啊。下一个状态，完全由当前状态决定！！
    private void Queen(int row, int ld, int rd) {//ld, left 对角线; rd, right 对角线
         int pos, p;
         if(row!=upper)
         {
             //so pos in binary is like, under current row/ld/rd restriction, what is available slot to put Q
             pos = upper & (~(row | ld |rd));
             while(pos!=0)//available is 1
             {
                 p = pos & (-pos);//from right to left, the first "1" in pos
                 //now, we occupy the most right available position
                 pos = pos - p;//now take this available as ”Q“，pos kind of like a available slot marker
                 Queen(row+p,(ld+p)<<1,(rd+p)>>1);
             }
         }
         else 
        	 ++cnt;
    }
    
}
