package binary_search.search_2d_matrix2_240;

/*
240. Search a 2D Matrix II
https://leetcode.com/problems/search-a-2d-matrix-ii/

Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

public class Solution {

    // Great not recursive solution - binary search tree
    // https://discuss.leetcode.com/topic/20064/my-concise-o-m-n-java-solution O(n+m) time complexity.
    // Same idea
    // https://discuss.leetcode.com/topic/45543/my-c-soluation-using-binary-search-tree-model-beats-100
    // we can treat the left bottom as a root of a BST so we only need o(m+N) to find the target
    boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m ==0) return false;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while (row < m && col >= 0) {
            int curr = matrix[row][col];
            if (curr == target) return true;
            if (curr > target) col--;
            else row++; // if (cur<target) ...
        }
        return false;
    }
}
