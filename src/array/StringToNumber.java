package array;

/**
 * Created by rajeshsubramanian on 3/21/18.
 */
public class StringToNumber {

    public static void main( String[] args ) {
        System.out.println(convertStringToNumber("1234"));
    }

    private static int convertStringToNumber( String numStr ) {

            char ch[] = numStr.toCharArray();
            int sum = 0;
            //get ascii value for zero
            int zeroAscii = (int)'0';
            for(char c:ch){
                int tmpAscii = c;
                sum = (sum*10)+(tmpAscii-zeroAscii);
            }
            return sum;
    }
}
