package string;

import java.util.*;

public class WordPattern {

    public static void main(String[] args) {

        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abab", "red blue red cat"));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length != pattern.length())
            return false;
        Map<Object, Integer> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            Object a = map.put(pattern.charAt(i), i);
            Object b = map.put(strs[i], i);
            if(!Objects.equals(a, b))
                return false;
        }
        return true;
    }
}
