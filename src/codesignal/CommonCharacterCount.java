package codesignal;

public class CommonCharacterCount {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";

        System.out.println(solution(s1, s2));
    }
    static int solution(String s1, String s2) {
        int[] s1_count = new int[26];
        int[] s2_count = new int[26];

        for (char curr : s1.toCharArray()) {
            s1_count[curr - 'a']++;
        }

        for (char curr : s2.toCharArray()) {
            s2_count[curr - 'a']++;
        }

        int count = 0;
        for(int i = 0; i < s1_count.length; i++) {
                count += Math.min(s1_count[i], s2_count[i]);
        }
        return count;
    }
}
