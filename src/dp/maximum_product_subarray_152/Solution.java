package dp.maximum_product_subarray_152;

/*
152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/

Find the contiguous subarray within an array (containing at least one number)
 which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
// Time complexity O(n), space complexity O(1)
// Good solution
// https://discuss.leetcode.com/topic/5161/simple-java-code
public class Solution {
    int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i=1; i<nums.length; i++) {
            int temp = max;
            int el = nums[i];
            int max1 = Math.max(max * el, min * el);
            max = Math.max(max1, el);
            int min1 = Math.min(temp * el, min * el);
            min = Math.min(min1, el);
            if (max > result) result = max;
        }
        return result;
    }
}