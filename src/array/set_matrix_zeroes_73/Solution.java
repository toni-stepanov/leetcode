package array.set_matrix_zeroes_73;

/**
 73. Set Matrix Zeroes
 https://leetcode.com/problems/set-matrix-zeroes/

 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class Solution {
    // Good solution
    //https://discuss.leetcode.com/topic/5056/any-shortest-o-1-space-solution
    void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // matrix[0][0] - is common for row0 and col0, thus we could use matrix[0][0] for row0,
        // and col0 variable for col0;
        int col0 = 1;
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) col0 = 0; // make this check before updates in the loop below.
            for (int j=1; j<n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // first col update.
                    matrix[0][j] = 0;
                }
            }
        }
        // go from bottom to the top to save the data in the first row
        for (int i=m-1; i>=0; i--) {
            // this loop is no metter left-right, or right-left,
            // because we will update first column outside of the loop depending on col0.
            for (int j=n-1; j>=1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }

}