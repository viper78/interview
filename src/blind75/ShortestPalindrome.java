package blind75;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {

        if (s == null || s.length() == 0) return s;
        if(isPalindrome(s)) return s;

        int index = s.length() - 1;
        while (index >= 0) {
            String end = s.substring(index);
            StringBuilder sb = new StringBuilder(end).reverse();
            if(isPalindrome(sb + s)) return sb + s;
            index--;
        }
        return s;
    }

    boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while(left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
