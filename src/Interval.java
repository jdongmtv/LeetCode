import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Interval {
	
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	
	//insert order is also very important
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		for(Interval interval : intervals) {
			if(interval.end < newInterval.start) {
				res.add(interval);
			} else if(interval.start > newInterval.end) { 
				 res.add(newInterval);
				 newInterval = interval;
			} else  {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end  = Math.max(interval.end, newInterval.end);
			}
		}
		res.add(newInterval);
		return res;
	}
	
	//not difficult at all, sort it first
	public List<Interval> merge(List<Interval> intervals) {
	   List<Interval> res = new ArrayList<>();
	   Collections.sort(intervals, new Comparator<Interval>() {
		   @Override
		   public int compare(Interval o1, Interval o2) {
			   return o1.start-o2.start;
		  }
	   });
	   for(Interval interval : intervals) {
		   if(res.size() == 0)
			   res.add(interval);
		   else {
			   Interval lastInterval = res.get(res.size()-1);
			   if(lastInterval.end<interval.start)
				   res.add(interval);
			   else {
				   lastInterval.start = Math.min(lastInterval.start, interval.start);
				   lastInterval.end = Math.max(lastInterval.end, interval.end);
			   }
		   }
	   }
	   return res;
	}
	
}
