package array;

public class ConsecutiveNumberSum {

    public static void main(String[] args) {

        possibleConsecutiveSum(100);
    }

    private static void possibleConsecutiveSum(int n) {

        int start = 1;
        int end = (n + 1)/2;

        while (start < end) {

            int sum = 0;

            for (int i = start; i <= end; i++) {

                sum += i;

                if (sum == n) {

                    for (int j = start; j <= i; j++) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                    break;
                }

                if (sum > n)
                    break;
            }

            sum = 0;
            start++;
        }
    }
}
