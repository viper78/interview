package codesignal;

public class LuckyNumber {

    public static void main(String[] args) {
        int n = 239017;
        System.out.println(solution(n));
    }
    static boolean solution(int n) {

        String str = String.valueOf(n);

        int leftSum = 0;
        int rightSum = 0;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            leftSum += str.charAt(left) - '0';
            rightSum += str.charAt(right) - '0';
            left++;
            right--;
        }

        return leftSum == rightSum;
    }
}
