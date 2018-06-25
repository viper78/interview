package string;

public class SentenceUppercase {

    public static void main(String[] args) {

        String str = "sentence to convert to uppercase";
        System.out.println(toUppercase(str));

    }

    public static String toUppercase(String str) {

        String result = "";
        String[] words = str.split("\\s");

        for (String word : words) {
            result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }

        return result;
    }
}
