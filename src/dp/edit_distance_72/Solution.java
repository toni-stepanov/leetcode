package dp.edit_distance_72;


/*
72. Edit Distance
https://leetcode.com/problems/edit-distance/#/description

Given two words word1 and word2, find the minimum number of steps required to convert
word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
// m == word1.length(), n == word2.length(),
// Time complexity O(mn), space complexity O(mn).
// https://web.stanford.edu/class/cs124/lec/med.pdf
// https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
public class Solution {




//    https://leetcode.com/problems/edit-distance/discuss/25846/20ms-detailed-explained-c-solutions-on-space
//    If they are not equal, we need to consider three cases:
//    Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1 (for replacement));
//    Delete word1[i - 1] and word1[0..i - 2] = word2[0..j - 1] (dp[i][j] = dp[i - 1][j] + 1 (for deletion));
//    Insert word2[j - 1] to word1[0..i - 1] and word1[0..i - 1] + word2[j - 1] = word2[0..j - 1] (dp[i][j] = dp[i][j - 1] + 1 (for insertion)).
    int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // equal
                } else {
                    int min1 = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1); // insert, delete
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, min1); // replace
                }
            }
        }
        return dp[m][n];
    }
}