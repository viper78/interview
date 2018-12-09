package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ZeroSum {
    // Continuous Numbers
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2 ,-2, 1, 4 ,-4);
        System.out.println(isZero(list));

    }

    public static List<Integer> isZero(List<Integer> a) {

        List<Integer> ans = new ArrayList<Integer>();

        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int prev = 0;

        //int end = 0;
        int length = 0;
        for (int i = 0; i < a.size(); i++){
            sum += a.get(i);
            if (map.containsKey(sum)){
                int current = map.get(sum);
                if (i - current > length){
                    prev = current;
                    length = i - current;
                }
            }else{
                map.put(sum, i);
            }
        }

        for (int i = 0; i < length; i++){
            ans.add(a.get(prev + 1 + i));
        }

        return ans;

    }
}
