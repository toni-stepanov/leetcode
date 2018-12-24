package math.powXN_50;

/*
50. Pow(x, n)
https://leetcode.com/problems/powx-n/

Implement pow(x, n).
*/
public class Solution {
    /**
     * 1. We should reduce number of * operations, because of
     * a) efficiency
     * b) accumulated error when looks like x.000000023423
     * We cen do it next way:
     * 2^16 = 2^8*2^8 = (2*2)^8 = 4^8 = 4^4 * 4^4 = (4*4)^4 = 16^4 ...
     * when n%2==1 => 2^5 = 2^1 *2^2 *2^2 = 2 * (2*2)^2
     * 2. In case of negative power, for instance n=-3, x^-3 = 1/(x^3) = (1/3)^3 =>
     * just need to switch: n=-n , x=1/x;
     */
    // Set of solutions
    // https://discuss.leetcode.com/topic/21837/5-different-choices-when-talk-with-interviewers/2
    // https://discuss.leetcode.com/topic/5425/short-and-easy-to-understand-solution/3
    double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // negative case
        boolean extra = false;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                extra = true;
            } else {
                n = -n;
            }

            x = 1 / x;
        }

        double temp = 1.0;
        if (extra) {
            temp *= x;
        }

        while (n != 1) {
            if (n % 2 != 0) {
                temp *= x;
            }

            x *= x;
            n /= 2;
        }

        return x * temp;
    }
}