package array;

public class FizzBuzz {

    public static void main(String[] args) {
        int num = 15;
        fizzBuzz(num);
    }

    private static void fizzBuzz(int num) {

        int count = 1;

        while (count <= num) {

            if (count < 3) {
                System.out.println(count);
            } else {
                String str = "";
                if (count % 3 == 0) {
                    str += "Fizz";
                }
                if (count % 5 == 0) {
                    str += "Buzz";
                }
                if (str.isEmpty()) {
                    System.out.println(count);
                } else {
                    System.out.println(str);
                }
            }

            count++;
        }



    }
}
