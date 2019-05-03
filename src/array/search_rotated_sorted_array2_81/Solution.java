package array.search_rotated_sorted_array2_81;

/**
 81. Search in Rotated Sorted Array II
 https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class Solution {

    boolean search(int[] nums, int target) {
        int start = 0 , end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid]  == target) return true;
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;end--;
            } else if(nums[start] <= nums[mid]){ // left is sorted
                if(target >= nums[start] && target < nums[mid]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else if(nums[end] >= nums[mid]) { // right is sorted
                if(target <= nums[end] && target > nums[mid]){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return false;
    }
}