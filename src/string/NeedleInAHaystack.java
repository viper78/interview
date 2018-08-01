package string;

public class NeedleInAHaystack {

    public static void main(String[] args) {

        String s1 = "haystack";
        String s2 = "stack";

        System.out.println(findSubstring(s1, s2));
    }

    private static int findSubstring(String s1, String s2) {

        if (s1 == null || s2 == null || s2.length() > s1.length())
            return -1;

        int size = s2.length();

        for (int i = 0; i <= s1.length() - size; i++) {
            String temp = s1.substring(i, i+ size);
            if (temp.equals(s2)) {
                return i;
            }
        }

        return -1;
    }
}
