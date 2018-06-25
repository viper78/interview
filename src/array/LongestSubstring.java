package array;

public class LongestSubstring {

    public static void main(String[] args) {

        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.longestSubString("abcad"));
    }

    public String longestSubString(String str) {

        char[] arr = str.toCharArray();
        int[] count = new int[256];
        String out = "";

        for (int i = 0; i < arr.length; i++) {

            if (count[arr[i]] == 0) {
                count[arr[i]] = 1;
                out += arr[i];
            } else {
                break;
            }
        }

        return out;
    }
}
