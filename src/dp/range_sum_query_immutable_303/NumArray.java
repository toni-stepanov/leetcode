package dp.range_sum_query_immutable_303;

/*
303. Range Sum Query - Immutable
https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
// https://discuss.leetcode.com/topic/29194/java-simple-o-n-init-and-o-1-query-solution
class NumArray {
    private int[] nums;

    // Time complexity O(n), space complexity O(n)
    NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    // Time complexity O(1)
    int sumRange(int i, int j) {
        if (nums.length == 0 || i > j || j >= nums.length || i >= nums.length) {
            return 0;
        }
        if (i == 0) return nums[j];
        return nums[j] - nums[i - 1];
    }
}
