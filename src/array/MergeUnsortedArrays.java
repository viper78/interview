package array;

import java.util.Arrays;

public class MergeUnsortedArrays {

    public static void main(String[] args) {
        int[] array1= {5,4,6,2,1};
        int[] array2= {2,5,8,4,1,6,4};
        merge(array1, array2);
        merge2(array1, array2);

    }

    private static void merge(int[] array1, int[] array2) {
        int m=array1.length;
        int n=array2.length;
        int[] array3=new int[m+n];
        int a=0;
        for(int i=0;i<m;i++) {

            array3[i]=array1[i];//array1 is copied to array3
        }
        for(int i=0;i<n;i++) {
            array3[m+a]=array2[i];//array2 is copied to array3
            a++;
        }
        //array3 is combined array
        int l=array3.length;
        int temp[]=new int[l];
        for(int i=0;i<l;i++) {
            for(int j=i+1;j<l;j++) {
                if(array3[i]>array3[j]) {
                    temp[i]=array3[i];
                    array3[i]=array3[j];
                    array3[j]=temp[i];
                }
            }
        }
        System.out.println("sorted array is ");
        System.out.print("[");
        for(int i=0;i<l;i++) {
            System.out.print(array3[i]+" ");
        }
        System.out.print("]");
    }

    private static void merge2(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[n + m];

        int i = 0;
        int j = 0;
        int index = 0;

        while( i < n && j < m) {

            result[index++] = arr1[i];
            result[index++] = arr2[j];
            i++;
            j++;
        }

        while (i < n) {
            result[index++] = arr1[i];
            i++;
        }

        while (j < m) {
            result[index++] = arr2[j];
            j++;
        }

        System.out.println();
        Arrays.sort(result);
        Arrays.stream(result).forEach(s -> System.out.print(s + " "));
    }

}
