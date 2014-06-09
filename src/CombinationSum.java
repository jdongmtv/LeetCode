import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {

	   public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
	        if(candidates==null||candidates.length==0)
	            return results;
	        ArrayList<Integer> result = new ArrayList<>();
	        Arrays.sort(candidates);
	        combinationSum(results, result, candidates, target,0);
	        return results;
	    }
	    
	    private void combinationSum(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int[] candidates, int target,int index) {
	        
	        if(target==0) {
	            ArrayList<Integer> tmp = (ArrayList<Integer>)result.clone();
	            results.add(tmp);
	            return;
	        }
	        if(target<0 || index == candidates.length)
	            return;
	            
	        result.add(candidates[index]);
	        combinationSum(results, result, candidates, target-candidates[index], index);
	        result.remove(result.size()-1);
	        
	        combinationSum(results, result, candidates, target, index+1);
	    }
	    
	    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
	        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
	        if(candidates==null||candidates.length==0)
	            return results;
	        ArrayList<Integer> result = new ArrayList<>();
	        Arrays.sort(candidates);
	        combinationSum2(results, result, candidates, target,0);
	        return results;
 	    } 
 	    
	    private void combinationSum2(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result, int[] candidates, int target,int start) {
	        
	        if(target==0) {
	            ArrayList<Integer> tmp = (ArrayList<Integer>)result.clone();
	            results.add(tmp);
	            return;
	        }
	        
	        if(target<0 || start>=candidates.length)
	            return;
	        for(int i=start;i<candidates.length;i++) {
	            result.add(candidates[i]);
	            combinationSum2(results, result, candidates, target-candidates[i], i+1);
	            result.remove(result.size()-1);
	            while(i+1<candidates.length && candidates[i] == candidates[i+1])
	                i++;
	        }
	   }
	    
	    public static void main(String[] args) {
	    	
	    }

}
