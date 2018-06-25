package dynamic;

/**
 * Created by rajeshsubramanian on 2/21/18.
 */
public class StringEdit {

    public static void main( String[] args ) {
        String str1 = "abcdef";
        String str2 = "obodce";

        System.out.println("Minimun edits: " +stringedit(str1.toCharArray(), str2.toCharArray()));
    }

    private static int stringedit( char[] char1, char[] char2 ) {

        int[][] arr = new int[char1.length + 1][char2.length + 1];

        for (int i = 0; i <= char1.length; i++) {
            for (int j = 0; j <=char2.length; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = 0;
                } else if (i == 0 && j > 0) {
                    arr[0][j] = j;
                } else if (j == 0 && i > 0) {
                    arr[i][0] = i;
                } else {
                    if (char1[i-1] == char2[j-1]) {
                        arr[i][j] = arr[i-1][j-1];
                    } else {
                        arr[i][j] = Math.min(Math.min( arr[i][j-1], arr[i-1][j] ), arr[i-1][j-1]) + 1;
                    }
                }
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        return arr[char1.length][char2.length];
    }
}
