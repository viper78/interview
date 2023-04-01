package blind75;

import java.util.HashMap;
import java.util.Map;

public class LongestTwoLetterElementPalindrome {

    public static void main(String[] args) {
        String[] words = {"cc","ll","xx", "cc","cc", "ll","ll"};
        System.out.println(longestPalindrome(words));
    }
    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        boolean flag = false;
        int result = 0;
        for (String str: map.keySet()) {
            String reversed = new StringBuilder(str).reverse().toString();
            if (str.equals(reversed)) {
                int count = map.get(str);
                if (count % 2 != 0) {
                    count--;
                    flag = true;
                }
                result += 2*count;
                map.put(str, map.get(str) - count);

            } else if (map.containsKey(reversed)) {
                int minCount = Math.min(map.get(str), map.get(reversed));
                result += 4*minCount;
                map.put(str, map.get(str) - minCount);
                map.put(reversed, map.get(reversed) - minCount);
            }
        }

        return flag ? result + 2 : result;
    }
}
