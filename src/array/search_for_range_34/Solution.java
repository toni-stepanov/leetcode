package array.search_for_range_34;

/**
 * 34. Search for a Range
 * https://leetcode.com/problems/search-for-a-range/
 * <p>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Solution {

    int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        if(nums.length == 0) {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        ret[0] = searchMin(nums, 0, nums.length - 1, target);
        ret[1] = searchMax(nums, 0, nums.length - 1, target);
        return ret;
    }

    private int searchMin(int[] nums, int l, int r, int target) {
        if (l == r) {
            if (nums[l] == target) {
                return l;
            }
            return -1;
        }
        if (l == r - 1) {
            if (nums[l] == target) {
                return l;
            }
            return searchMin(nums, l + 1, r, target);
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] >= target) {
            return searchMin(nums, l, mid, target);
        } else {
            return searchMin(nums, mid + 1, r, target);
        }
    }

    private int searchMax(int[] nums, int l, int r, int target) {
        if (l == r) {
            if (nums[l] == target) {
                return l;
            }
            return -1;
        }
        if (l == r - 1) {
            if (nums[r] == target) {
                return r;
            }
            return searchMax(nums, l, r - 1, target);
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] > target) {
            return searchMax(nums, l, mid - 1, target);
        } else {
            return searchMax(nums, mid, r, target);
        }
    }
}