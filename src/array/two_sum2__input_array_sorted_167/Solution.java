package array.two_sum2__input_array_sorted_167;

/**
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such
 * that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are
 * not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {
    // Two pointers
    // Time complexity O(n), space complexity O(1);
    // Binary search O(n*log n) time complexity.
    // https://discuss.leetcode.com/topic/7465/a-less-efficient-way-binary-search
    // 3 cool solutions
    //https://discuss.leetcode.com/topic/21800/python-different-solutions-two-pointer-dictionary-binary-search
    int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int curSum = numbers[lo] + numbers[hi];
            if (curSum == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (curSum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};
    }
}