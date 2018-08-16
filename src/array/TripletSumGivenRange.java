package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumGivenRange {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[] {"0.6", "1.2", "0.8", "0.7", "0.4"});
        System.out.println(solve(list));
    }

    public static int solve(List<String> A) {
        if(A.size() < 3) return 0;

        double a = Double.parseDouble(A.get(0));
        double b = Double.parseDouble(A.get(1));
        double c = Double.parseDouble(A.get(2));

        for(int i = 3; i < A.size(); i++){

            if((a+b+c) > 1 && (a+b+c) < 2){
                return 1;
            }


            double n = Double.parseDouble(A.get(i));


            if((a+b+c) >= 2){
                if(a > b && a > c){
                    a = n;
                } else if( b > c){
                    b = n;
                } else{
                    c = n;
                }
            } else{
                if(a < b && a < c){
                    a = n;
                } else if( b < c){
                    b = n;
                } else{
                    c = n;
                }
            }
        }

        if((a+b+c) > 1 && (a+b+c) < 2){
            return 1;
        }

        return 0;

    }
}
