package backtracking.combination_sum2_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum-ii/
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
public class Solution {

    // Good solution
    // https://discuss.leetcode.com/topic/19845/java-solution-using-dfs-easy-understand/2
    // Looks like time complexity O(n^n), space complexity - O(n)
    // https://discuss.leetcode.com/topic/44037/combination-sum-i-ii-and-iii-java-solution-see-the-similarities-yourself
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, curr, res);
        return res;
    }

    // this method is just a recursive tree, depth is - n, number of branches starts from the n-1 and decreasing to 0
    // Space complexity is O(n) - the depth of the recursive tree
    private void dfs(int[] candidates, int target, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, path, res);
                path.remove(path.size() - 1);
            }
        } else if (target == 0) {
            res.add(new ArrayList<>(path));
        }
    }
}