package array;

public class LongestPalindromeShuffle {

    public static void main(String[] args) {

        String str = "abbaccd";

        System.out.println(compute(str));
    }

    private static String compute(String str) {

        int[] count = new int[256];
        for (char ch : str.toCharArray()) {
            count[ch]++;
        }

        StringBuilder beg = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder end = new StringBuilder();

        for (char c = 'a'; c <= 'z'; c++) {

            if (count[c] % 2 != 0) {
                mid.append(String.valueOf(c));
                count[c]--;
            } else {
                for (int i = 0; i < count[c]/2; i++) {
                    beg.append(String.valueOf(c));
                }
            }
        }
        System.out.println("Beg:"+ beg.toString());
        System.out.println("Mid:"+ mid.toString());
        end = beg.reverse();
        System.out.println("End:"+end.toString());


        return beg.toString()+ mid.toString() + beg.reverse().toString();
    }
}
