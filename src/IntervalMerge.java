import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class IntervalMerge {

	   public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	        ArrayList<Interval> result = new ArrayList<Interval>();
	        if(intervals == null || intervals.size() == 0)
	            return result;
	        Collections.sort(intervals, new Comparator<Interval>() {
	        	@Override
	        	public int compare(Interval o1, Interval o2) {
	        		return o1.start-o2.start;
	        	}
			});
	        result.add(intervals.get(0));
	        for(int i=1;i<intervals.size();i++) {
	            Interval interval = intervals.get(i);
	            Interval tmpResult = result.get(result.size()-1);
	               if(interval.start<=tmpResult.end) {
	                    tmpResult.end = Math.max(interval.end, tmpResult.end);
	                    tmpResult.start = Math.min(tmpResult.start, interval.start);
	                } else {
	                    result.add(intervals.get(i));
	                }
	        }
	        return result;
	    }
	   
	 public boolean isPalindrome(String s) {
	     if(s==null || s.length() == 0)
	         return true;
	     int lo = 0, hi = s.length() -1;
	     s = s.toLowerCase();
	     while(lo<hi) {
	         while(lo<s.length() && (s.charAt(lo)<'a' || s.charAt(lo)>'z'))
	             lo++;
	         while(hi>=0 && (s.charAt(hi)<'a' || s.charAt(hi)>'z' ))
	             hi--;
	         if(s.charAt(lo)!=s.charAt(hi))
	             return false;
	         lo++; 
	         hi--;
	     }
	     return true;
	 }
	
	public static void main(String[] args) {
		   ArrayList result = new ArrayList<>();
		   new IntervalMerge().isPalindrome("a.");
	}
	
}
