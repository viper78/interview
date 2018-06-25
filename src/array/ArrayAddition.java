package array;

/**
 * Created by rajeshsubramanian on 3/8/18.
 */
public class ArrayAddition {


    public static void main(String args[]){

        int arr1[] = {9,9,9,9,9,9,9};
        int arr2[] = {1,6,8,2,6,7};
        ArrayAddition aa = new ArrayAddition();
        int result[] = aa.add(arr1, arr2);
        for ( int k = 0; k < result.length; k++ ) {
            System.out.print(" " + result[k]);
        }

    }

    private int[] add( int[] arr1, int[] arr2 ) {
        int len = Math.max( arr1.length, arr2.length );
        int[] result = new int[len];
        int carry = 0;
        int i = arr1.length-1;
        int j = arr2.length-1;
        int sum = 0;
        len--;
        while ( i >=0 && j >=0 ) {
            sum = arr1[i--] + arr2[j--] + carry;
            carry = sum/10;
            result[len--] = sum%10;
        }

        while ( i >= 0 ) {
            sum = arr1[i--] + carry;
            carry = sum/10;
            result[len--] = sum%10;
        }

        while ( j >= 0 ) {
            sum = arr2[j--] + carry;
            carry = sum/10;
            result[len--] = sum%10;
        }

        if (carry != 0) {
            int[] newresult = new int[result.length + 1];
            for (int t = newresult.length-1; t>0; t--) {
                newresult[t] = result[t-1];
            }
            newresult[0] = carry;

            return newresult;
        }

        return result;
    }
}
