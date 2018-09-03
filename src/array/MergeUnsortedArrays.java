package array;

import java.util.Arrays;

public class MergeUnsortedArrays {

    public static void main(String[] args) {
        int[] array1= {5,4,6,2,1};
        int[] array2= {2,5,8,4,1,6,4};
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

}
