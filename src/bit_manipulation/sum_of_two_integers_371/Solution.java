package bit_manipulation.sum_of_two_integers_371;

/*
371. Sum of Two Integers
https://leetcode.com/problems/sum-of-two-integers/description/

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/
public class Solution {

    int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while(b!=0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    // Iterative
    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }

    // Recursive
    int getSumRec(int a, int b) {
        return (b == 0) ? a : getSumRec(a ^ b, (a & b) << 1);
    }

    // Recursive
    int getSubtractRec(int a, int b) {
        return (b == 0) ? a : getSubtractRec(a ^ b, (~a & b) << 1);
    }

    // Get negative number
    public int negate(int x) {
        return ~x + 1;
    }
}