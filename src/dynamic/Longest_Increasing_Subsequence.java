package dynamic;

import java.util.Arrays;

/**
 * Created by rajeshsubramanian on 2/15/18.
 */
public class Longest_Increasing_Subsequence {

    public static void main( String[] args ) {

        int[] arr = new int[]{0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
        System.out.println(longestSubsequenceWithActualSolution(arr));
    }

    public static int longestSubsequenceWithActualSolution(int arr[]){
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }

        Arrays.stream(actualSolution).forEach(System.out::print);
        System.out.println();
        //find the index of max number in T
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }

        //lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();

        return T[maxIndex];
    }
}
