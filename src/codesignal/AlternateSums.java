package codesignal;

public class AlternateSums {

    public static void main(String[] args) {
        int[] a= {50, 60, 60, 45, 70};
        System.out.println(solution(a));
    }
    static int[] solution(int[] a) {
        int leftSum = 0;
        int rightSum = 0;
        int[] output = new int[2];

        for (int i = 0; i < a.length; i++) {
            if ((i+1) % 2 == 0) {
                leftSum += a[i];
            } else {
                rightSum += a[i];
            }
        }
        output[0] = leftSum;
        output[1] = rightSum;

        return output;
    }
}
