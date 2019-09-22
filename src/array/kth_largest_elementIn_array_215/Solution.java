package array.kth_largest_elementIn_array_215;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * <p>
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ? k ? array's length.
 */
// use quick selection algorithm

public class Solution {
    // https://en.wikipedia.org/wiki/Quickselect
    int findKthLargest(int[] nums, int search) {
        if (search > nums.length) return 0;
        // turn the task to find n-th smallest element
        search = nums.length - search;
        int left = 0, right = nums.length - 1;
        while (true) {
            if (left == right) return nums[left];
            int pivotIndex = left; // select pivot index between left and right
            int pivotUpdatedIndex = partition(nums, left, right, pivotIndex);
            if (pivotUpdatedIndex == search) return nums[search];
            else if (pivotUpdatedIndex < search) left = pivotUpdatedIndex + 1;
            else right = pivotUpdatedIndex - 1;
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        if (left == right) return left;
        int pivot = nums[pivotIndex];
        swap(nums, right, pivotIndex);
        int storeIndex = left;
        for (int i = left; i <= right - 1; i++) { // because nums[right] is pivot now
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right); // move pivot to final position
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}