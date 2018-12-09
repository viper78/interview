package array;

import java.util.List;

public class DiffK {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(diffPossible(nums, 3));
    }

    public static int diffPossible(int[] A, int B) {
        int i=0;
        int j=1;
        while(j<A.length && i<A.length){

            int diff=(A[j] - A[i]);
            if(diff==B && i!=j)
                return 1;
            if((A[j]-A[i]) < B)
                j++;
            else i++;
        }
        return 0;
    }
}
