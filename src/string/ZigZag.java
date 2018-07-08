package string;

public class ZigZag {

    public static void main(String[] args) {

        String str = "PAYPALISHIRING";

        String output = printZigZag(str, 3);

        System.out.println(output);
    }

    private static String printZigZag(String str, int rows) {

        if (rows == 1 || rows > str.length()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();

        int interval = 2 * rows - 2;

        for (int i = 0; i < rows; i++) {

            int step = interval - 2*i;

            for (int j = i; j < str.length(); j += interval) {

                sb.append(str.charAt(j));

                if (step > 0 && step < interval && j + step < str.length()) {
                    sb.append(str.charAt( j + step));
                }
            }
        }

       return sb.toString();
    }
}
