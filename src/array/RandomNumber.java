package array;

import java.util.*;

public class RandomNumber {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("apple", "mango", "peach", "cherry", "banana", "orange", "pineapple");
        Set<Integer> set = new HashSet();
        set.add(-1);
        Random random = new Random();

        int n = fruits.size();

        int rand = -1;
        for (int i = 0; i < n; i++) {
            while (!set.add(rand) ) {
                rand = random.nextInt( (n-1-0)+1 ) + 0;
            }
            System.out.println(fruits.get(rand));
        }
    }
}
