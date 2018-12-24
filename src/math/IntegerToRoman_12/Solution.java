package math.IntegerToRoman_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
12. Integer to Roman
https://leetcode.com/problems/integer-to-roman/

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
// Roman numbers
// https://en.wikipedia.org/wiki/Roman_numerals
// Amazing solution
// https://discuss.leetcode.com/topic/12384/simple-solution
class Solution {

    Map<Integer, List<Character>> map = new HashMap<>();
    {
        map.put(1, Arrays.asList('I', 'X', 'C', 'M'));
        map.put(5, Arrays.asList('V', 'L', 'D'));
    }

    String intToRoman(int num) {
        StringBuilder ret = new StringBuilder();
        int offset = 0;
        while (num != 0) {
            int rem = num%10;
            num /= 10;
            ret.append(getDigits(rem, offset));
            offset++;
        }
        return ret.reverse().toString();
    }

    String getDigits(int n, int offset) {
        if (n ==1 || n == 5) return String.valueOf(getDigit(n, offset));
        else if (n > 1 && n < 4) return repeat(getDigit(1, offset), n);
        else if (n == 4) return String.valueOf((getDigit(5, offset)) + String.valueOf(getDigit(1, offset)));
        else if (n> 5 && n < 9) return (repeat(getDigit(1, offset), (n-5)) + getDigit(5, offset));
        else if (n == 9) return String.valueOf((getDigit(1, offset + 1)) + String.valueOf(getDigit(1, offset)));
        else return "";
    }

    private String repeat(Character digit, int repeat) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            ret.append(digit);
        }
        return ret.toString();
    }

    Character getDigit(int n, int offset) {
        List<Character> list = map.get(n);
        return list.get(offset);
    }


    public static String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

}