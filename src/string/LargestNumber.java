package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {

        String[] arr = {"48", "5", "4", "1"};

        List<String> list = Arrays.asList(arr);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String s1 = o1 + o2;
                String s2 = o2 + o1;

                return (s1.compareTo(s2) > 0 ? -1 : 1);
            }
        });

        list.stream().forEach(s -> System.out.print(s + " "));
    }
}
