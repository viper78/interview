package array;

import java.util.*;

public class NMaxPair {

    public static void main(String[] args) {

        List<Integer> input1 = Arrays.asList(1,5,3);
        List<Integer> input2 = Arrays.asList(1,6,7);

        System.out.println(solve(input1, input2));
    }

    public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        int n = A.size();

        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        for(int i:A){
            for(int j:B){
                int s = i+j;
                if (pq.size()<n){
                    pq.add(s);
                } else {
                    if (s > pq.peek()){
                        pq.poll();
                        pq.add(s);
                    }
                }
            }
        }

        ArrayList<Integer> ret = new ArrayList<>(pq);
        Collections.sort(ret,Collections.reverseOrder());
        return ret;
    }
}
