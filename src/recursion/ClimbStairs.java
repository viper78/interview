package recursion;

import java.util.Arrays;

public class ClimbStairs {

    public static void main(String[] args) {

        int steps = 10;
        //System.out.println(naiveWay(steps));

        steps = 44;

        int[] helper = new int[steps+1];
        System.out.println(noOfWays(steps, helper));

//        Arrays.stream(helper).forEach(System.out::println);
    }

    private static int noOfWays(int steps, int[] helper) {

        if (helper[steps] != 0) {
            return helper[steps];
        }
        if (steps == 0) return 0;
        if (steps == 1) {
            helper[steps] = 1;
        } else if (steps == 2) {
            helper[steps] = 2;
        } else {
            helper[steps] = noOfWays(steps-1, helper) + noOfWays(steps-2, helper) + noOfWays(steps-3, helper);
        }

        return helper[steps];
    }

    private static int naiveWay(int steps) {

        if (steps == 0) return 0;
        if (steps == 1) return 1;
        if (steps == 2) return 2;

        return naiveWay(steps - 1) + naiveWay(steps - 2) + naiveWay(steps - 3);
    }

}
