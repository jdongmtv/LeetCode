import java.util.*;

public class Candy {
	
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int sum = 0;
        int size = ratings.length;
        int[] candy = new int[size];
        for(int i=0; i<size; i++)
            candy[i] = 1;
        for(int i=0; i<size-1; i++) {
            if(ratings[i]<ratings[i+1])
                candy[i+1] = candy[i]+1;
        }
        for(int i=size-1;i>=1;--i) {
            if(ratings[i-1]>ratings[i] && candy[i-1] <= candy[i])
                candy[i-1] = candy[i] +1;
        }
        for(int i=0;i<size;i++)
            sum +=candy[i];
        return sum;
    }
    
    public static void main(String[] args) {
    	int ratings[] = {2,2};
    	new Candy().candy(ratings);
    	LinkedList<Character> stack = new LinkedList<Character>();
    }
}
