package backtracking.n_queen_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
51. N-Queens
https://leetcode.com/problems/n-queens/

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
*/
class Solution {
    List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] solution = new int[n];
        Arrays.fill(solution, -1);
        recursion(solution, 0, n, res);
        return res;
    }

    public void recursion(int[] solution, int curLevel, int maxN, List<List<String>> res) {
        if (curLevel == maxN) {
            res.add(drawString(solution));
        } else {
            for (int column = 0; column < maxN; column++) {
                if (check(solution, curLevel, column)) {
                    solution[curLevel] = column;
                    recursion(solution, curLevel + 1, maxN, res);
                    solution[curLevel] = -1;
                }
            }
        }
    }

    public boolean check(int[] solution, int curLevel, int column) {
        for (int i = 0; i < curLevel; i++) {
            if (solution[i] == column) return false;
            if (Math.abs(curLevel - i) == Math.abs(solution[i] - column)) return false;
        }
        return true;
    }

    private List<String> drawString(int[] solution) {
        int n = solution.length;
        List<String> res = new ArrayList<>();
        for (int aSolution : solution) {
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < n; j++) {
                if (aSolution == j) sb.append("Q");
                else sb.append(".");
            }
            res.add(sb.toString());
        }
        return res;
    }
}