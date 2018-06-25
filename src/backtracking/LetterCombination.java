package backtracking;

import java.util.*;

public class LetterCombination {

    public static void main(String[] args) {

        LetterCombination lc = new LetterCombination();
        System.out.println(lc.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "");

        ArrayList<String> result = new ArrayList<String>();

        if(digits == null || digits.length() == 0)
            return result;

       // getString(digits, new StringBuilder(), result, 0, map);
        System.out.println();
        combo(digits, "", result, 0, map, null);

        return result;
    }

    public void combo(String digits, String prefix, ArrayList<String> result,  int index, HashMap<Character, String> map, HashSet<String> wordSet) {

        if (index == digits.length()) {
//            System.out.print(prefix + " ");
            result.add(prefix);
            return;
        }
        char curr = digits.charAt(index);
        char[] letters = map.get(curr).toCharArray();

        for (char c : letters) {
            combo(digits, prefix + c, result, index + 1, map, wordSet);
        }

    }



    public void getString(String digits, StringBuilder temp, ArrayList<String> result,  int index, HashMap<Character, String> map){

        if (index == digits.length()) {
            System.out.print(temp.toString() + "  ");
            result.add(temp.toString());
            return;
        }

        char curr = digits.charAt(index);
        String letters = map.get(curr);
        for(int i=0; i<letters.length(); i++){
            temp.append(letters.charAt(i));
            getString(digits, temp, result, index + 1, map);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
