package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedNumber {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,4,1,5,1);
        System.out.println(repeatedNum(list));
    }

    public static int repeatedNum(final List<Integer> a) {
        if (a == null || a.size() == 0)
            return -1;
        List<Integer> result = new ArrayList<Integer>();

        int number1 = a.get(0), number2 = a.get(0), count1 = 0, count2 = 0, len = a.size();

        for (int i = 0; i < len; i++) {
            if (a.get(i) == number1)
                count1++;
            else if (a.get(i) == number2)
                count2++;
            else if (count1 == 0) {
                number1 = a.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                number2 = a.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (a.get(i) == number1)
                count1++;
            else if (a.get(i) == number2)
                count2++;
        }
        if (count1 > len / 3) {
            return number1;
        }
        if (count2 > len / 3) {
            return number2;
        }
        return -1;
    }
}
