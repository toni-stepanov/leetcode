package dp.minimum_path_sum_64;

/*
64. Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/

Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes
the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {

    // Time and space complexity O(m*n)
    int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] ways = new int[m][n];
        ways[0][0] = grid[0][0];
        for (int i=1; i<n; i++) {
            ways[0][i] = grid[0][i] + ways[0][i-1];
        }
        for (int j=1; j<m; j++) {
            ways[j][0] = grid[j][0] + ways[j-1][0];
        }

        for(int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                ways[i][j] = Math.min(ways[i-1][j], ways[i][j-1]) + grid[i][j];
            }
        }
        return ways[m-1][n-1];
    }
}
