package array;

public class CheckAnagram {

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        System.out.println(isAnagram(str1, str2));
    }

    private static boolean isAnagram(String str1, String str2) {

        // Array to hold number of occurences of each letter
        int[] count = new int[26];

        if (str1.length() != str2.length()) return false;

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            count[c1[i]]++;
            count[c2[i]]--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                return false;
            }
        }

        return true;
    }

}
