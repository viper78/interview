package blind75;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                String s1 = strs[j];
                String s2 = strs[j+1];

                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLength);
    }
}
