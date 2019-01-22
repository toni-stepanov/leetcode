package backtracking.combination_sum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
39. Combination Sum
https://leetcode.com/problems/combination-sum/

Given a set (SET MEANS UNIQUE!!!! NO DUPLICATES!!!!) of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
*/
public class Solution {

    //https://discuss.leetcode.com/topic/7698/java-solution-using-recursive
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getResult(candidates, target, 0, new LinkedList<>(), result);
        return result;
    }

    private void getResult(int[] candidates, int target, int index, LinkedList<Integer> list, List<List<Integer>> result) {
        if (target > 0) {
            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                list.add(candidates[i]);
                getResult(candidates, target - candidates[i], i, list, result);
                list.remove(list.size() - 1);
            }
        } else if (target == 0) {
            result.add(new LinkedList<>(list));
        }
    }
}