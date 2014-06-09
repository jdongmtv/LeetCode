import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
	
	  public List<List<Integer>> threeSum(int[] num) {
	        List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(num);
	        for(int i=0;i<num.length-2;i++) {
	        	if(i>0 && num[i] == num[i-1])
	        		continue;
	        	int target = -num[i];
	        	int lo = i+1, hi= num.length-1;
	        	while(lo<hi) {
	        		if(num[lo] + num[hi] == target) {
	        			List<Integer> tmp = new ArrayList<>(); 
	        			tmp.add(num[i]);
	        			tmp.add(num[lo]);
	        			tmp.add(num[hi]);
	        			result.add(tmp);
	        			while(lo+1<num.length && num[lo] == num[lo+1])
	        				 ++lo;
	        			while(hi>0&& num[hi] == num[hi-1])
	        				--hi;
	        			++lo;
	        			--hi;
	        		} else if(num[lo] + num[hi] >target) {
	        			--hi;
	        		} else {
	        			++lo;
	        		}
	        	}
	        }
	        return result;
	  }
	  
	    public int threeSumClosest(int[] num, int target) {
		  	int diff = Integer.MAX_VALUE;
		  	int result = -1;
	        Arrays.sort(num);
	        for(int i=0;i<num.length-2;i++) {
	        	if(i>0 && num[i] == num[i-1])
	        		continue;
	        	int lo = i+1, hi= num.length-1;
	        	while(lo<hi) {
	        		int sum = num[i] + num[lo] + num[hi];
	        		if(sum == target) {
	        			return target;
	        		} else if(sum >target) {
	        			if(Math.abs(sum-target)<diff) {
	        				diff = Math.abs(sum-target);
	        				result = sum;
	        			}
	        			--hi;
	        		} else {
	        			if(Math.abs(sum-target)<diff) {
	        				diff = Math.abs(sum-target);
	        				result = sum;
	        			}
	        			++lo;
	        		}
	        	}
	        }
	        return result;
	  }
	  
}
