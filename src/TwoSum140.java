import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TwoSum140 {
	public List<String> combine(Iterator<String> itr1,Iterator<String> itr2) {
		
		List<String>  result = new ArrayList<String>();
		while(itr1.hasNext())
			result.add(itr1.next());
		while(itr2.hasNext())
			result.add(itr2.next());
		return result;
	}
}
