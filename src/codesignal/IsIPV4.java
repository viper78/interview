package codesignal;

public class IsIPV4 {

    public static void main(String[] args) {
        String str = "172.16.254.1";
        System.out.println(solution(str));
    }
    static boolean solution(String inputString) {

        if (inputString == null || inputString.length() == 0) {
            return false;
        }

        // 250 - 255 -> 25[0-5]
        // 200 - 249 -> 2[0-4][0-9]
        // 100 - 199 -> 1[0-9][0-9]
        // 10 - 99 -> [1-9][0-9]
        // 0 - 9 -> [0-9]
        String regex = "25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]";
        String[] parts = inputString.split("\\.");
        if (parts.length != 4) return false;
        for (String str: parts) {
            if (!str.matches(regex)) {
                return false;
            }
        }
        return true;
    }

}
