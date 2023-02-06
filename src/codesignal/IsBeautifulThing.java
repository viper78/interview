package codesignal;

public class IsBeautifulThing {

    public static void main(String[] args) {
        String str = "bbbaacdafe";
        System.out.println(solution(str));
    }
    static boolean solution(String inputString) {
        int[] count = new int[26];
        for (char c: inputString.toCharArray()) {
            count[c - 'a']++;
        }

        int prev_count = count[0];
        for (int i = 1; i < count.length; i++) {
            if (prev_count == 0) {
                return false;
            }
            int curr_count = count[i];
            if (curr_count > prev_count) {
                return false;
            }
            prev_count = curr_count;
        }
        return true;
    }

}
