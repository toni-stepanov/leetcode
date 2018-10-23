package math.add_strings_415;

/*
415. Add Strings
https://leetcode.com/problems/add-strings/

Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class Solution {
    String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("num1 and num2 should not be null");
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >=0; i--, j--) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            result.insert(0, sum%10);
            carry = sum/10;
        }
        if (carry > 0) result.insert(0, carry);
        return result.toString();
    }
}
