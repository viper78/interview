package binarysearch;

import java.util.Arrays;
import java.util.List;

public class SortedInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(Arrays.asList(1,3,5,6), 0));
    }

    public static int searchInsert(List<Integer> a, int b) {
        int l=0;
        int r=a.size()-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(a.get(mid)==b)
                return mid;
            if(a.get(mid)>b)
                r=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
}
