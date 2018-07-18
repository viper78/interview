package array;

import java.util.*;

public class SmallestSequence {

    public static void main(String[] args) {

        int[] nums = {2,3,5};
        int k = 5;

        List<Integer> list = sequence(2,3,5, k);

        System.out.println(list);
    }

    private static List<Integer> sequence(int a, int b, int c, int k) {

        List<Integer> list = new ArrayList();

        TreeSet<Integer> set = new TreeSet<>();
        set.add(a);
        set.add(b);
        set.add(c);

        for (int i = 0; i < k; i++) {

            int temp = set.first();
            set.remove(temp);
            list.add( temp );

            set.add(temp * a);
            set.add(temp * b);
            set.add(temp * c);
        }

        return list;
    }
}
