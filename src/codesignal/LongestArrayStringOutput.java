package codesignal;

import java.util.*;

public class LongestArrayStringOutput {

    public static void main(String[] args) {
        String[] arr = {"aba", "aa", "ad", "vcd", "aba"};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static String[] solution(String[] inputArray) {

        Map<Integer, List<String>> map = new HashMap<>();
        for (String str: inputArray) {
            map.computeIfAbsent(str.length(), v-> new ArrayList<>()).add(str);
        }
        Optional<Integer> key = map.keySet().stream().sorted((a, b)-> b.compareTo(a)).findFirst();
        List<String> result = map.get(key.get());
        return result.toArray(new String[result.size()]);

    }
}
