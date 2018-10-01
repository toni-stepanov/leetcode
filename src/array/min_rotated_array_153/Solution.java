package array.min_rotated_array_153;

/**
 153. Find Minimum in Rotated Sorted Array
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */

class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length -1);
    }

    private int findMin(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l)/2;
        if (nums[mid] > nums[r]) {
            return findMin(nums, mid + 1, r);
        } else  {
            return findMin(nums, l, mid);
        }
    }
}

