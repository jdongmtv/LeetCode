import java.util.ArrayList;


public class GrayCode {

    public ArrayList<Integer> grayCode(int n) {
        int size = 1<<n;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<size; i++) {
            int tmp = (i>>1)^i;
            result.add(tmp);
        }
        return result;
    }
    
}
