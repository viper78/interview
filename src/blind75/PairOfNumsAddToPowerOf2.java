package blind75;

import java.util.HashMap;
import java.util.Map;

public class PairOfNumsAddToPowerOf2 {

    public static void main(String[] args) {
        int[] a = {1, -1, 2, 3};
        int ans=0;
        for(int i=0;i<31;i++){
            int key = (int)Math.pow(2, i);
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0; j<a.length; j++) {
                if(key == a[j]) {
                    ans++;
                }
                if(map.containsKey(key-a[j])) {
                    ans += map.get(key - a[j]);
                }
                map.put(a[j], map.getOrDefault(a[j],  0) +1);
            }
        }
        System.out.println("Total:"+ ans);
    }

}
