package dp.maximum_subarray_53;

/*
53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution
using the divide and conquer approach, which is more subtle.
*/
public class Solution {
    // refactored
    // Space complexity O(1)
    // https://discuss.leetcode.com/topic/5000/accepted-o-n-solution-in-java
    int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], sum = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    // log n ?
}