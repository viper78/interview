package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main( String[] args ) {
        int[] numbers = {-2,-3,4,5,6};
        int target = 3;

        int[] result = findPair( numbers, target );
        Arrays.stream(result).forEach( System.out::println );

        int[] result2 = findPair2( numbers, target );
        Arrays.stream(result2).forEach( System.out::println );
    }

    private static int[] findPair(int[] numbers, int target) {

        int[] result = {-1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];

            if (map.containsKey( temp )) {
                result[0] = map.get( temp );
                result[1] = i;

                break;
            } else {
                map.put( numbers[i], i );
            }
        }
        return result;
    }

    private static int[] findPair2(int[] numbers, int target) {

        int i = 0;
        int j = 1;
        int[] result = new int[2];

        while (i < numbers.length && j < numbers.length) {

            int sum = numbers[i] + numbers[j];

            if (sum == target) {

                result[0] = numbers[i];
                result[1] = numbers[j];
                break;
            } else if (sum < target) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }
}
