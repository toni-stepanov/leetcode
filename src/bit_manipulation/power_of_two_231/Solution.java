package bit_manipulation.power_of_two_231;

/*
231. Power of Two
https://leetcode.com/problems/power-of-two/
Given an integer, write a function to determine if it is a power of two.
*/
// Must read with all the links!!!
// http://www.exploringbinary.com/ten-ways-to-check-if-an-integer-is-a-power-of-two-in-c/
public class Solution {
    // Iterative solution
    // Time complexity O(log n)
    boolean isPowerOfTwo1(int n) {
        while (n % 2 == 0 && n > 1) {
            n /= 2;
        }
        return n == 1;
    }

    //Recursive
    boolean isPowerOfTwo2(int n) {
        return (n == 1) || (n % 2 == 0 && isPowerOfTwo2(n / 2));
    }

    // Bit operation x&(x-1) trick
    boolean isPowerOfTwo3(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    // Bit operation x&(~x+1) trick
    boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n&(~n+1)) == n);
    }
}