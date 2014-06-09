
public class SortColor {

    public void sortColors(int[] A) {
        if(A==null || A.length <=1)
            return;
        int red = 0, white = 0, blue = A.length -1;
        while( white <= blue ) {
            if(A[white] == 0) {
                int tmp = A[white];
                A[white] = A[red];
                A[red] = tmp;
                ++red;
                ++white; // the white is always behind red 
            } else if(A[white] == 2) {
                int tmp = A[white];
                A[white] = A[blue];
                A[blue] = tmp;
                --blue;
                // the exchanged element is possibly red, we cann't increase white
                // because we need to deal with the red ball in next loop
            } else {
                 ++white;
            }
        }
    }
    
    public static void main(String[] args) {
    	int A[] = {1,2,0};
    	new SortColor().sortColors(A);
    }
    
}
