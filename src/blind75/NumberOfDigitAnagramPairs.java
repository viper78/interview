package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfDigitAnagramPairs {

    public static void main(String[] args) {

        int[] nums = {25,35,872,228,53,278,872};
        int result = 0;

        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int n: nums) {
            String s = String.valueOf(n);
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            int key = Integer.valueOf(new String(arr));
            freqMap.put(key, freqMap.getOrDefault(key, 0)+1);
        }

        for (int count : freqMap.values()) {
            if (count < 2) continue;
            result += (count * (count -1))/2;
        }

        System.out.println("No of Pairs: "+result);
    }
}
