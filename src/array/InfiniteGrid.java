package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfiniteGrid {

    public static void main(String[] args) {
        List<Integer> X = Arrays.asList(0, 1, 1);
        List<Integer> Y = Arrays.asList(0, 1, 3);

        System.out.println(coverPoints(X, Y));
    }

    public static int coverPoints(List<Integer> X, List<Integer> Y) {
        int numSteps = 0;
        for(int i = 1; i < X.size(); i++){
            numSteps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) );
        }
        return numSteps;
    }
}
