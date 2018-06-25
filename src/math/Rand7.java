package math;

public class Rand7 {
    public static void main(String[] args) {
        System.out.println(rand5());
    }

    private static int rand5(){
        double d = Math.random();
        d = d*5;
        return (int)(Math.ceil(d));
    }
}
