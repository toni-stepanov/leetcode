package math.roman_to_integer_13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*


Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
*/
class Solution {

    public int romanToInt(String s) {
        int result = 0, current, next;
        char[] symbols = s.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            current = getIntFromChar(symbols[i]);
            if ((i + 1) < symbols.length) {
                next = getIntFromChar(symbols[i + 1]);
                if (current < next) {
                    current = next - current;
                    i++;
                }
            }
            result += current;
        }
        return result;
    }

    private static int getIntFromChar(char symbol) {
        if ('I' == symbol) {
            return 1;
        } else if ('V' == symbol) {
            return 5;
        } else if ('X' == symbol) {
            return 10;
        } else if ('L' == symbol) {
            return 50;
        } else if ('C' == symbol) {
            return 100;
        } else if ('D' == symbol) {
            return 500;
        } else if ('M' == symbol) {
            return 1000;
        } else {
            return 0;
        }
    }

}