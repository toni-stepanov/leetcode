package array.product_of_array_except_self_238;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * Given an array of n integers where n > 1, nums, return an array
 * output such that output[i] is equal to the product of all the
 * elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of
 * space complexity analysis.)
 */

public class Solution {
    // Good solution with explanation
    // https://discuss.leetcode.com/topic/22301/my-solution-beats-100-java-solutions
    // The product basically is calculated using the numbers before the current number
    // and the numbers after the current number. Thus, we can scan the array twice. First,
    // we calcuate the running product of the part before the current number. Second,
    // we calculate the running product of the part after the current number through scanning from the end of the array.
    int[] productExceptSelf(int[] nums) {
        int leng = nums.length;
        int[] ret = new int[leng];
        if (leng == 0)
            return ret;
        int runningprefix = 1;
        for (int i = 0; i < leng; i++) {
            ret[i] = runningprefix;
            runningprefix *= nums[i];
        }
        int runningsufix = 1;
        for (int i = leng - 1; i >= 0; i--) {
            ret[i] *= runningsufix;
            runningsufix *= nums[i];
        }
        return ret;
    }
}