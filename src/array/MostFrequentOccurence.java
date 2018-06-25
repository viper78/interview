package array;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentOccurence {

    public static void main(String[] args) {
        int[] arr = {1,3,4,1,3,1,2};
//        System.out.println(naiveSolution(arr));
        System.out.println(mostOccurence(arr));
    }




    private static int naiveSolution(int[] arr) {

        int max = Integer.MIN_VALUE;
        int num = -1;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length ; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            max = Math.max(max, count);
            if (max == count) {
                num = arr[i];
            }

        }
        return num;
    }

    private static int mostOccurence(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key,  1);
            }
        }

        return Collections.max(map.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();

//        Map.Entry<Integer, Integer> maxEntry = null;
//        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
//                maxEntry = entry;
//            }
//        }
//        return maxEntry.getKey();
//        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

    }
}
