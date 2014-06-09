import java.util.Arrays;


public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		 int[] result = new int[2];
		 Holder[] holders = new Holder[numbers.length];
		 for(int i=0;i<numbers.length;i++) {
			 holders[i] = new Holder(numbers[i], i+1);
		 }
		 Arrays.sort(holders);
		 int lo = 0, hi = numbers.length - 1;
		 while(lo<hi) {
			 if((holders[lo].number + holders[hi].number) == target) {
				 result[0] = holders[lo].index;
				 result[1] = holders[hi].index;
				 break;
			 } else if((holders[lo].number + holders[hi].number) > target) {
				 --hi;
			 } else {
				 ++lo;
			 }
		 }
		 Arrays.sort(result);
		 return result;
	 }
	 
	 static class Holder implements Comparable<Holder> {
		int number;
		int index;
		
		Holder(int number, int index) {
			 this.number = number;
			 this.index = index;
		}
		
		@Override
		public int compareTo(Holder o) {
			return this.number - o.number;
		}
		
	 }
	 
}
