import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum {
	
	 public List<List<Integer>> fourSum(int[] num, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(num);
	        for(int i=0;i<num.length-3;i++) {
		        	if(i>0 && num[i] == num[i-1])
		        		continue;
	        	for(int j=i+1;j<num.length-2;j++){
	        		if(j>i+1 && num[j] == num[j-1])
	        			continue;
		        	int sum = target-num[i]-num[j];
		        	int lo = j+1, hi= num.length-1;
		        	while(lo<hi) {
		        		if(num[lo] + num[hi] == sum) {
		        			List<Integer> tmp = new ArrayList<>(); 
		        			tmp.add(num[i]);
		        			tmp.add(num[j]);
		        			tmp.add(num[lo]);
		        			tmp.add(num[hi]);
		        			
		        			result.add(tmp);
		        			while(lo+1<num.length && num[lo] == num[lo+1])
		        				 ++lo;
		        			while(hi>0&& num[hi] == num[hi-1])
		        				--hi;
		        			++lo;
		        			--hi;
		        		} else if(num[lo] + num[hi] >sum) {
		        			--hi;
		        		} else {
		        			++lo;
		        		}
		        	}
		        }
	        }
	        return result;
	  }
	 
}
