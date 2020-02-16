package array.combination_sum3_216;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/
 * <p>
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Example 1:
 * Input: k = 3, n = 7
 * <p>
 * Output:
 * [[1,2,4]]
 * <p>
 * Example 2:
 * Input: k = 3, n = 9
 * <p>
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
//https://discuss.leetcode.com/topic/37962/fast-easy-java-code-with-explanation
public class Solution {

    List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void combination(List<List<Integer>> result, List<Integer> curList, int k, int n, int index) {
        if (curList.size() == k && n == 0) {
            result.add(new ArrayList<>(curList));
        } else {
            for (int i = index; i <= 9 && n > 0; i++) {
                curList.add(i);
                combination(result, curList, k, n - i, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

}
