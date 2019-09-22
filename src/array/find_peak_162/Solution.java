package array.find_peak_162;

/**
 * https://leetcode.com/problems/find-peak-element/
 A peak element is an element that is greater than its neighbors.
 Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 You may imagine that nums[-1] = nums[n] = -∞.
 */

public class Solution {

    int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if (l ==r) {
            return l;
        }
        int m = (l+r)/2;
        if (nums[m] > nums[m+1]) {
            return search(nums, l, m);
        } else {
            return search(nums, m + 1, r);
        }
    }

}

