package array.next_permutation_31;

import java.util.Arrays;

/**
 31. Next Permutation
 https://leetcode.com/problems/next-permutation/
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 Lexicographical permutation algorithm
 https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class Solution {

    void nextPermutation(int[] nums) {
        int[] sortedArray = new int[nums.length];
        System.arraycopy(nums, 0, sortedArray, 0, nums.length);
        Arrays.sort(sortedArray);
        if (ascendingOrder(sortedArray, nums)) {
            System.arraycopy(sortedArray, 0, nums, 0, nums.length);
            return;
        }
        int i = nums.length - 1;
        while (i>0 && nums[i-1] >= nums[i]) {
            i--;
        }
        i--;
        for (int j = nums.length - 1; j >= i; j--) {
            if (nums[j] > nums[i]) {
                swap(nums, i,j);
                break;
            }
        }
        Arrays.sort(nums, i+1, nums.length);
    }

    private void swap(int[] nums, int i, int i2) {
        int temp = nums[i2];
        nums[i2] = nums[i];
        nums[i] = temp;
    }

    private boolean ascendingOrder(int[] sortedArray, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedArray[sortedArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}

