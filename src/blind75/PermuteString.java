package blind75;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {
    public static void main(String[] args) {
        String str ="123";
        List<Integer> list = new ArrayList<>();
        permute(str, "", list);
        list.forEach(System.out::println);
    }

    static void permute(String str, String progress, List<Integer> list) {

        if (str.length() == 0) {
            list.add(Integer.valueOf(progress));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i+1);

            permute(remaining, progress + curr, list);
        }
    }
}
