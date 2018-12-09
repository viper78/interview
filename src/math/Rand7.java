package math;

public class Rand7 {
    public static void main(String[] args) {

        int count = 0;
        int num = 0;
        while (count < 1) {
            num = 5 * rand5() + rand5();
            if (num < 29) {
                System.out.println(num % 7);
            } else {
                System.out.println("ofr:" + num);
            }
            count++;
        }

    }

    private static int rand5(){
        double d = Math.random();
        d = d*5;
        int result = (int)(Math.ceil(d));
        return result;
    }

}
