package array;

public class RotateArrayInPlace {

    public void rotate(int[][] matrix) {
        int length = matrix.length-1;
        int j=0;
        while(j < matrix.length/2){
            for(int i=j; i < length-j; i++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[length-i][j];
                matrix[length-i][j] = matrix[length-j][length-i];
                matrix[length-j][length-i] = matrix[i][length-j];
                matrix[i][length-j] = temp;
            }
            j++;
        }
    }

    public void rotateAnti(int[][] matrix) {
        int length = matrix.length-1;
        int j=0;
        while(j < matrix.length/2){
            for(int i=j; i < length-j; i++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][length-j];
                matrix[i][length-j] = matrix[length-j][length-i];
                matrix[length-j][length-i] = matrix[length -i][j];
                matrix[length -i][j] = temp;
            }
            j++;
        }
    }

    private void print(int arr[][]){
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]){

        int matrix[][] = {{1,2,3,4,20},{5,6,7,8,30},{9,10,11,12,40},{13,14,15,16,50},{21,22,23,24,25}};
        RotateArrayInPlace ti = new RotateArrayInPlace();
        ti.print(matrix);
        //ti.rotate(matrix);
        System.out.println();
        //ti.print(matrix);
        System.out.println();
        ti.rotateAnti(matrix);
        ti.print(matrix);
    }


}
