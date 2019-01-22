package bit_manipulation.PowerOfFour_342;

/*
342. Power of Four
https://leetcode.com/problems/power-of-four/

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/
public class Solution {
    // Good solution
    // https://discuss.leetcode.com/topic/42860/java-1-line-cheating-for-the-purpose-of-not-using-loops
    // mask  0x55555555 is 0101010101010101, can be used to check the even bits of a given number
    // x & 0x55555555 returns non-zero (=true) if any even bit it set (bit 0, bit 2, bit 4, bit 6, etc).
    // That means it's power of 4. (i.e. 2 doesn't pass, but 4 passes, 8 doesn't pass, 16 passes, etc).
    boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num-1)) == 0) && ((num & 0x55555555) != 0);
    }


    boolean isPowerOfFour3(int num) {
        int i = num & 0x55555555;
        return (num >0) && Integer.bitCount(i) == 1 && i == num;
    }

    public boolean isPowerOfFour2(int num) {
        if (num  == 1) {
            return true;
        }
        while (num > 0) {
            if (num %4 == 0) {
                num /= 4;
                if (num == 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}