package array;

public class StringRotation {

    public static void main(String[] args) {

        String str1 = "AACD";
        String str2 = "ACDA";

        System.out.println(isStringRotated(str1, str2));
    }

    private static boolean isStringRotated(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        if ((str1 + str1).indexOf(str2) == -1) return false;

        return true;
    }
}
