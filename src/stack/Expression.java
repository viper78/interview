package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Expression {

    public static void main(String[] args) {
        System.out.println(colorful(234));
    }

    public static int colorful(int A) {

        String numStr = String.valueOf(A);

        int n = numStr.length();

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < n ; i++) {
            for(int j = i ; j < n ; j++) {
                int res = 1;

                for(int k = i ; k <= j ; k++) {
                    res *= Integer.parseInt(numStr.substring(k,k+1));
                }

                if(set.contains(res)) return 0;
                else set.add(res);
            }
        }

        return 1;
    }

}
