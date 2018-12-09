package binarysearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MatrixMedian {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> i1 = new ArrayList<>();
        i1.add(1);
        i1.add(3);
        i1.add(5);
        ArrayList<Integer> i2 = new ArrayList<>();
        i2.add(2);
        i2.add(6);
        i2.add(9);
        ArrayList<Integer> i3 = new ArrayList<>();
        i3.add(3);
        i3.add(6);
        i3.add(9);

        input.add(i3);
        input.add(i1);
        input.add(i2);

        System.out.println(findMedian(input));
    }

        public static int findMedian(ArrayList<ArrayList<Integer>> A) {
            if ( A == null || A.size() == 0 )
                return 0;

            int N = A.size();
            int M = A.get( 0 ).size();
            int medIdx = N*M / 2;

            PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>( N, new Comparator<ArrayList<Integer>>() {
                public int compare( ArrayList<Integer> a1, ArrayList<Integer> a2 ) {
                    return a1.get(0).compareTo(a2.get(0));
//                    return Integer.compare( a1.get( 0 ), a2.get( 0 ) );
                }
            });

            for ( int i = 0; i < N; i++ ) {
                queue.offer( A.get( i ) );
            }

            int idx = 0;
            int num = 0;
            while( idx <= medIdx ) {
                ArrayList<Integer> row = queue.poll();
                num = row.remove( 0 );
                System.out.print(num + " ");
                if ( row.size() > 0 )
                    queue.offer( row );
                idx++;
            }
            System.out.println();
            return num;
        }

}
