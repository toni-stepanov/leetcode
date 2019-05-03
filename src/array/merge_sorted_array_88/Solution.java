package array.merge_sorted_array_88;

/**
 * Created by astepanov on 22.09.2018.
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Solution {

    void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return;
        int p = m-1;
        int q = n-1;
        int i = nums1.length - 1;
        while (p>=0 && q>=0) {
            if (nums1[p]>nums2[q]) {
                nums1[i] = nums1[p];
                p--;
            } else {
                nums1[i]=nums2[q];
                q--;
            }
            i--;
        }
        while(q>=0) {
            nums1[i]=nums2[q];
            q--;
            i--;
        }
    }

}