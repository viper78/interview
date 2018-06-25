package backtracking;

public class ListOfSubsets {

    public static void main(String[] args) {
        
        int[] numsArray = {1,2, 2};
        int size = 2;
        int[] solutionArray = new int[size];
        
        solve(numsArray, solutionArray, 0, size);
    }

    private static void solve(int[] numsArray, int[] solutionArray, int index, int size) {

        for (int i = 0; i < size; i++) {
            System.out.print(solutionArray[i] + " ");
        }
        System.out.println();

        for (int i = index; i < size; i++) {
            solutionArray[i] = numsArray[i];
            solve(numsArray, solutionArray, index + 1, size);
            solutionArray[i] = 0;
        }
    }
}
