package array;

public class SecondLargest {

    public static void main( String[] args ) {
        int arr[] = {12, 35, 1, 10, 34, 1};
        int n = arr.length;
        print2largest(arr);
    }

    private static void print2largest( int[] arr ) {

        if (arr.length < 2) return;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if ( arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        System.out.println(second);

    }
}
