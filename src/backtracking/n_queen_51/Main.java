package backtracking.n_queen_51;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> result = s.solveNQueens(5);
        result.forEach(System.out::print);
    }
}
