package string;

import java.util.HashMap;

public class MinimumWindow {

    public static void main(String[] args) {
        MinimumWindow mw = new MinimumWindow();
        String out = mw.minWindow("ADOBECODEBANC", "ABC");

        System.out.println(out);
    }

    public String minWindow(String source, String target) {
        // preload for target checking
        if(source == null || source.length() == 0 || target == null || target.length() == 0)
            return "";


        int tarLen = target.length();
        HashMap<Character, Integer> dict = new HashMap<>();
        for(char c : target.toCharArray())
            dict.put(c, dict.containsKey(c)? dict.get(c) + 1 : 1);

        int hitCount = 0; // record current window hits how many characters in target
        int prevIdx = 0; // record the left bound of current window
        int minWindow = source.length() + 1; // initial the minimum window length
        int start = 0;
        for(int i = 0; i < source.length(); i++) {
            char cur = source.charAt(i);
            // if current char is not in dict, continue
            if(!dict.containsKey(cur))
                continue;

            dict.put(cur, dict.get(cur) - 1);
            if(dict.get(cur) >= 0)
                hitCount++;

            // check the windows has amount of this char more than it in target string
            // loop until the amount back to normal, but always reduce the prev index char
            while(hitCount == tarLen) {
                if( minWindow > i - prevIdx + 1) {
                    start = prevIdx;
                    minWindow = i - prevIdx + 1;
                }
                char prevChar = source.charAt(prevIdx);
                if(dict.containsKey(prevChar)) {
                    dict.put(prevChar, dict.get(prevChar)+1);
                    if(dict.get(prevChar) > 0)
                        hitCount--;
                }
                prevIdx++;
            }
        }
        //
        if(minWindow > source.length())
            return "";
        return source.substring(start, start + minWindow);
    }

}
