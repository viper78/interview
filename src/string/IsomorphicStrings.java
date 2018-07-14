package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {

        String s1 = "acb";
        String s2 = "xxy";

        boolean flag = isIsomorphic(s1, s2);
        System.out.println(flag);
    }

    private static boolean isIsomorphic(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            if (map.containsKey(s1.charAt(i)) && !map.get(s1.charAt(i)).equals(s2.charAt(i))) {
                return false;
            } else if (map.containsKey(s2.charAt(i)) && !map.get(s2.charAt(i)).equals(s1.charAt(i))) {
                return false;
            } else {
                map.put(s1.charAt(i), s2.charAt(i));
                map.put(s2.charAt(i), s1.charAt(i));
            }
        }
        return true;
    }
}
