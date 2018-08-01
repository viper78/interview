package string;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }

    public static String countAndSay(int n)
    {
        String x="1";
        while(n>1) {
            x=count(x);
            n--;
        }
        return x;
    }
    public static String count(String x) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< x.length();i++) {
            int c=1;
            while(i+1 < x.length() && x.charAt(i)==x.charAt(i+1)) {
                c++;
                i++;
            }

            sb.append(c);
            sb.append(x.charAt(i));
        }

        return sb.toString();
    }
}
