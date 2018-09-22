package array.plus_one_66;

/**
 66. Plus One
 https://leetcode.com/problems/plus-one/
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */

public class Solution {
    int[] plusOne(int[] digits) {
        int[] ret;
        boolean plusOne = true;
        for (int i = digits.length - 1; i >=0; i--) {
            int value = digits[i];
            if (plusOne) {
                value+=1;
                if (value == 10) {
                    value =0;
                } else {
                    plusOne = false;
                }
            }
            digits [i] = value;
        }
        if (plusOne) {
            ret = new int[digits.length + 1];
            ret[0] = 1;
        } else {
            ret = digits;
        }
        return ret;
    }
}

