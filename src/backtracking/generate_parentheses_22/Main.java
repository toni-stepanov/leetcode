package backtracking.generate_parentheses_22;

import string.generate_parentheses_22.Solution;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.generateParenthesis(2);
        System.out.println(result);
    }
}
