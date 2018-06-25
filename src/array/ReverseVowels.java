package array;

public class ReverseVowels {

    public static void main(String[] args) {
        String str = "apple";
        String str1 = "friend";
        System.out.println(reverseVowels(str));
        System.out.println(reverseVowels(str1));
    }

    public static String reverseVowels(String str) {
        char[] arr = str.toCharArray();
        int l = 0;
        int r = str.length() - 1;

        while(l >= 0 && l < r) {

            if (isVowel(arr[l]) && isVowel(arr[r])) {
                //swap
                char temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;

                l++;
                r--;
            } else if (isVowel(arr[l]) && !isVowel(arr[r])) {
                r--;
            } else if (!isVowel(arr[l]) && isVowel(arr[r])) {
                l++;
            } else {
                l++;
                r--;
            }
        }

        return new String(arr);
    }

    private static boolean isVowel(char c) {

        return (c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u');
    }
}
