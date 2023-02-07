package codesignal;

public class BuildPalindrome {

    public static void main(String[] args) {
        String str = "abaa";
        System.out.println(solution(str));
    }
    static String solution(String st) {

        if (st.length() == 1) return st;
        if (ispalindrome(st)) return st;
        int index = 0;

        while (index < st.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(st.substring(0, index)).reverse();
            if (ispalindrome(st+sb.toString())) {
                return st+sb.toString();
            }
            index++;
        }
        return st;
    }

    static boolean ispalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
