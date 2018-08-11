package math;

public class PowerOfTwoNumbers {

    public static void main(String[] args) {

        System.out.println(isPower(15));
    }

    public static boolean isPower(int a) {
        if(a==1) return true;
        for (int i = 2; i*i <= a; i++) {
            int p = a;
            while(p%i == 0){
                p/=i;
            }
            if(p == 1) return true;
        }
        return false;

    }
}
