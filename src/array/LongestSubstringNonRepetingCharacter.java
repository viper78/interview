package array;

import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class LongestSubstringNonRepetingCharacter {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("javaconceptoftheday"));
        longestSubstring("javaconceptoftheday");
    }



    public static void longestSubstring(String str) {

        int max = 0;
        int k = 0;
        String longestSubstring = "";
        HashSet<Character> hashSet = new HashSet<>();

        char[] letters = str.toCharArray();

        for (int i = 0; i < letters.length; i++) {

            char c = letters[i];
            if (!hashSet.contains(c)) {
                hashSet.add(c);
                longestSubstring = hashSet.stream().map(s-> s + "").collect(joining(""));
                max = Math.max(max, hashSet.size());
            } else {
                while (k < i) {
                    if (str.charAt(k) == c) {
                        k++;
                        break;
                    } else {
                        hashSet.remove(str.charAt(k));
                        k++;
                    }
                }
            }
        }
        System.out.println(longestSubstring);
        System.out.println(max);

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int result = 0;
        int k=0;
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                result = Math.max(result, set.size());
            }else{
                while(k<i){
                    if(s.charAt(k)==c){
                        k++;
                        break;
                    }else{
                        set.remove(s.charAt(k));
                        k++;
                    }
                }
            }
        }

        return result;
    }
}
