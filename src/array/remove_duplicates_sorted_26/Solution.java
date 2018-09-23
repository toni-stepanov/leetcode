package array.remove_duplicates_sorted_26;

/**
 26. Remove Duplicates from Sorted Array
 https://leetcode.com/problems/remove-duplicates-from-sorted-array/

 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */

public class Solution {
    int removeDuplicates(int[] nums) {
        int p =0;
        if (nums.length < 2) {
            return nums.length;
        } else {
            for (int q = 1; q < nums.length; q++) {
                if (nums[p] != nums[q]) {
                    if (q != p+1) {
                        p++;
                        nums[p] = nums[q];
                    } else {
                        p++;
                    }
                }
            }
        }
        return p + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length<2) return nums.length;
        int i=1; // do not change nums[0]. Start updating from nums[1];
        for(int j=1; j<nums.length; j++) {
            if (nums[j-1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;// do not inc i, because it was already incremented in for loop.
    }
}

