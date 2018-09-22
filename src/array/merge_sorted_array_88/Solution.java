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
class Solution {

    void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind1 = nums1.length - 1;
        int ind2 = m - 1;
        if (ind1 == 0) {
            ind2 = 0;
        }
        int ind3 = n - 1;
        while (ind1 >= 0 && (ind2 >= 0 || ind3 >= 0)) {
            if (ind2 < 0) {
                nums1[ind1] = nums2[ind3];
                ind3--;
            } else if (ind3 < 0) {
                int temp = nums1[ind2];
                nums1[ind2] = 0;
                nums1[ind1] = temp;
                ind2--;
            } else {
                if (nums1[ind2] > nums2[ind3]) {
                    int temp = nums1[ind2];
                    nums1[ind2] = 0;
                    nums1[ind1] = temp;
                    ind2--;
                } else {
                    nums1[ind1] = nums2[ind3];
                    ind3--;
                }
            }
            ind1--;
        }
    }

}