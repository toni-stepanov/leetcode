package string.generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
@SuppressWarnings("Duplicates")
public class Solution {

    // https://discuss.leetcode.com/topic/36057/easy-java-solution
    //
    // https://discuss.leetcode.com/topic/8724/easy-to-understand-java-backtracking-solution
    // "The idea here is to only add '(' and ')' that we know will guarantee us a solution
    // (instead of adding 1 too many close). Once we add a '(' we will then discard it and try a ')'
    // which can only close a valid '('. Each of these steps are recursively called.
    //
    // This is binary tree with depth n -> time complexity O(branches^depth) -> O(2^n)
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n==0) return res;
        generateParenthesisRecursive(res, "", n, n);
        return res;
    }

    private void generateParenthesisRecursive(List<String> res, String current, int leftCnt, int rightCnt) {
        if (rightCnt==0) {
            res.add(current);
            return;
        }
        if (leftCnt>0) {
            generateParenthesisRecursive(res, current+"(", leftCnt-1, rightCnt);
        }
        if (rightCnt>leftCnt) {
            generateParenthesisRecursive(res, current+")", leftCnt, rightCnt-1);
        }
    }


}