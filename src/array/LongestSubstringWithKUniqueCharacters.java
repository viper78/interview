package array;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0 || s==null || s.length()==0)
            return 0;

        if(s.length()<k)
            return s.length();

        String longestSubstring = "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int maxLen=k;
        int left=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }

            if(map.size()>k){
                maxLen=Math.max(maxLen, i-left);
                if (maxLen > longestSubstring.length()) {
                    longestSubstring = s.substring(left, i+1);
                }

                while(map.size()>k){

                    char fc = s.charAt(left);
                    if(map.get(fc)==1){
                        map.remove(fc);
                    }else{
                        map.put(fc, map.get(fc)-1);
                    }

                    left++;
                }
            }

        }

        maxLen = Math.max(maxLen, s.length()-left);
        if (maxLen > longestSubstring.length()) {
            longestSubstring = s.substring(left+1);
        }

        System.out.println(longestSubstring);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("jaaavafool", 2));
    }
}
