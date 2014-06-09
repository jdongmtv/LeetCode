import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null)
            return 0;
        int size = triangle.size();
        ArrayList<Integer> pre = triangle.get(0);
        for(int i=1; i<size; i++) {
            ArrayList<Integer> cur = triangle.get(i);
            for(int j=0;j<cur.size();j++) {
                if(j==0)    cur.set(j, pre.get(j) + cur.get(j));
                else if(j==cur.size()-1) cur.set(j, pre.get(pre.size()-1) + cur.get(j));
                else {
                       int sum1 = pre.get(j-1) + cur.get(j);
                       int sum2 = pre.get(j) + cur.get(j);
                       if(sum1>sum2)
                            cur.set(j,sum2);
                        else
                            cur.set(j,sum1);
                }
            }
            pre  = cur;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<pre.size();i++) {
            if(pre.get(i)<min)
                min = pre.get(i);
        }
        return min;
    }
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0)
            return result;
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);
        for(int i=1; i<numRows;i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for(int j=0;j<=pre.size();j++) {
                if(j==0 || j==pre.size()) cur.add(1);
                else {
                  int tmp = pre.get(j-1) + pre.get(j);
                  cur.add(tmp);
                }
            }
            result.add(cur);
            pre = cur;
        }
        return result;
    }
    
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(rowIndex<0) {
            return result;
        }
        Integer[] dp = new Integer[rowIndex+1];
        Arrays.fill(dp, 0);
        dp[0]=1;
        for(int i=1; i<rowIndex+1; i++) {
             for(int j=i; j>=1; j--) {
                 dp[j]+=dp[j-1];
             }
         }
         return new ArrayList<Integer>(Arrays.asList(dp));
     }
    
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> arrayList = new ArrayList<Integer>(); arrayList.add(-1); triangle.add(arrayList);
    	arrayList = new ArrayList<Integer>(); arrayList.add(2); arrayList.add(3); triangle.add(arrayList);
    	arrayList = new ArrayList<Integer>(); arrayList.add(1); arrayList.add(-1); arrayList.add(-1); triangle.add(arrayList);
    	new Triangle().minimumTotal(triangle);
    	new Triangle().getRow(1);
    }
    
}
