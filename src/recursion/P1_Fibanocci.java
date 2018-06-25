package recursion;

import java.util.Arrays;

/**
 * Created by rajeshsubramanian on 2/14/18.
 */
public class P1_Fibanocci {

    static int n = 5;
    static int lookup[] = new int[n+1];
    public static void main( String[] args ) {
        Arrays.fill(lookup, 0);
        System.out.println(fib(n));
        Arrays.stream( lookup ).forEach( System.out::print );
    }

    private static int fib( int n ) {

        if (lookup[n] == 0) {
            if (n <= 1)
                lookup[n] =  n;
            else
                lookup[n] = fib( n-1 ) + fib( n-2 ) + 1;
        }

        return lookup[n];

    }
}
