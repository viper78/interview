package array;

import java.util.Arrays;

public class UniqueCharacter {

    public static void main(String[] args) {

        String s1 = "apple";
        String s2 = "ap1ple";

        xor(s1, s2);
    }

    private static void xor(String s1, String s2) {


        char[] sol = new char[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            sol[i] = (char) (s1.charAt(i) ^ s2.charAt(i));
        }
        System.out.print(new String(sol));
    }
}
