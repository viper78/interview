package blind75;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
    }
    public boolean isIsomorphic(String s, String t) {

        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] s_map = new int[256];
        int[] t_map = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char s_curr = s.charAt(i);
            char t_curr = t.charAt(i);
            if (s_map[s_curr] != t_map[t_curr]) {
                return false;
            }
            s_map[s_curr]++;
            t_map[t_curr]++;
        }
        return true;
    }
}
