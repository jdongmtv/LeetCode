import java.util.HashMap;


public class MaxPoints {

	   public int maxPoints(Point[] points) {
	        if(points == null || points.length == 0)
	            return 0;
	        HashMap<Double,Integer> map = new HashMap<>();
	        int max = 0;
	        for(int i=0;i<points.length;i++) {
	            map.clear();
	            int dup = 1;
	            map.put((double)Integer.MAX_VALUE, dup);
	            for(int j=i+1;j<points.length;j++) {
	                if(points[j].x == points[i].x && points[j].y == points[i].y) {
	                    ++dup;
	                    map.put((double)Integer.MAX_VALUE, dup);
	                } else {
	                    double k = (double) (points[j].x == points[i].x ? Integer.MAX_VALUE : (points[j].y-points[i].y)/(points[j].x-points[i].x));
	                    if(map.containsKey(k))  {
	                        map.put(k, map.get(k)+1);
	                    } else {
	                        map.put(k,2);
	                    }
	                }
	            }
	            for(Integer value : map.values()) {
	                if(dup+value > max)
	                    max = dup + value;
	            }
	        }
	        return max;
	    }
	   
	   public static void main(String[] args) {
	   }
}

  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
  