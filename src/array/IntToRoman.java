package array;

import java.util.*;

public class IntToRoman {

    public static void main (String[] args) {

        IntToRoman mycode = new IntToRoman();


        Map<Integer, String> map = new HashMap();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        int num = 1984;

        String roman = mycode.convert(num, map);

        System.out.println(roman);
    }

    public String convert(int number, Map<Integer, String> map) {

        StringBuilder sb = new StringBuilder();

        List<Integer> keys = new ArrayList(map.keySet());

        Collections.sort(keys, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });

        for (int i = 0; i < keys.size(); i++) {

            while (number >= keys.get(i)) {
                number -= keys.get(i);
                sb.append(map.get(keys.get(i)));
            }

        }
        return sb.toString();
    }

    private int romanToInteger(String roman) {
        HashMap<Character,Integer> romanMap = new HashMap<Character,Integer>();

        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        char[] rArr = roman.toCharArray();
        int sum = 0;
        for (int i = 0; i < rArr.length; i++) {

            int left = romanMap.get( rArr[i] );
            int right = 0;
            if (i + 1 < rArr.length) {
                right = romanMap.get( rArr[i+1] );
            }

            if (left >= right) {
                sum += left;
            } else {
                sum -= left;
            }
        }
        return sum;
    }

}
