package array.minimum_size_subarray_sum_209;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length
 * of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
// https://discuss.leetcode.com/topic/18583/accepted-clean-java-o-n-solution-two-pointers
public class Solution {
    int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (sum + nums[j] >= s) {
                sum = sum - nums[i];
                min = Math.min(min, (j - i + 1));
                i++;
            } else {
                sum += nums[j];
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}