package array.missing_number_268;

import java.util.Arrays;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */
public class Solution {

    int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (len) * (len + 1) / 2;
        for (int i: nums) {
            sum -= i;
        }
        return sum;
    }

    // xor solution
    public int missingNumber1(int[] nums) {
        int result = nums.length; //  because 1 element is missing, so max element in array == len, not len-1
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }

    // binary search, O(n*log n) because of Array.sort.
    public int missingNumber3(int[] nums) {// sum
        Arrays.sort(nums); // n * log n
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
