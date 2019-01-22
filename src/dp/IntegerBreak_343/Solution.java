package dp.IntegerBreak_343;

import java.util.Arrays;

/*
343. Integer Break
https://leetcode.com/problems/integer-break/

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

*/
// Time & space complexity O(1);
// https://discuss.leetcode.com/topic/42978/java-dp-solution - dp solution
public class Solution {

    int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int rem = n % 3;
        if (rem == 2) return (int) Math.pow(3, n / 3) * 2;
        if (rem == 1) return (int) Math.pow(3, (n - 4) / 3) * 4;
        return (int) Math.pow(3, n / 3); //if (n%3 == 0) return (int)Math.pow(3, n/3);
    }

    // https://leetcode.com/problems/integer-break/discuss/80694/Java-DP-solution
    int integerBreak2(int n) {
        //dp[i] means output when input = i, e.g. dp[4] = 4 (2*2),dp[8] = 18 (2*2*3)...
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // fill the entire dp array
        for (int i = 2; i <= n; i++) {
            //let's say i = 8, we are trying to fill dp[8]:if 8 can only be broken into 2 parts, the answer could be among 1 * 7, 2 * 6, 3 * 5, 4 * 4... but these numbers can be further broken. so we have to compare 1 with dp[1], 7 with dp[7], 2 with dp[2], 6 with dp[6]...etc
            for (int j = 1; j <= i / 2; j++) {
                // use Math.max1(dp[i],....)  so dp[i] maintain the greatest value
                int max1 = Math.max(i - j, dp[i - j]);
                int max2 = Math.max(j, dp[j]);
                dp[i] = Math.max(dp[i], max1 * max2);
            }
        }
        return dp[n];
    }
}