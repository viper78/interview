package array;

import java.util.Arrays;
import java.util.Optional;

public class LongestSubstringWithDigits {

    public static void main(String[] args) {

        String str = "aqW9ertYz";

        System.out.println(findLongest(str));
    }

    private static String findLongest(String str) {

        String[] arr = str.split("[0-9]");

        Optional<String> longest = Arrays.stream(arr)
                .filter(s -> s.matches("(.+)?[A-Z](.+)?"))
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst();
       return longest.get();
    }
}
