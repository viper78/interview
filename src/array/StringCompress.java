package array;

public class StringCompress {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','b','c','c','c','c'}));
    }


    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;

        StringBuffer buffer = new StringBuffer();
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) {
                count++;
            } else {
                buffer.append(chars[i]);
                if (count > 1)
                    buffer.append(count);
                count = 1;
            }
        }
        buffer.append( chars[chars.length-1]);
        if (count > 1)
            buffer.append(count);

        String out = buffer.toString();
        for ( int i = 0; i < out.length(); i++) {
            chars[i] = out.charAt(i);
        }

        return out.length();
    }
}
