package array.sum3_closest_16;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/

 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Solution {

    int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        int p = 0;
        while ((p + 3) <= nums.length) {
            int abs = Math.abs(target - (nums[p] + nums[p + 1] + nums[p + 2]));
            if (abs < diff) {
                diff = abs;
                sum = nums[p] + nums[p + 1] + nums[p + 2];
            }
            p++;
        }
        return sum;
    }

    int threeSumClosest2(int[] nums, int target) {
        if (nums.length < 4) {
            int res = 0;
            for(int i : nums) {
                res +=i;
            }
            return res;
        }
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int j=i+1, k=nums.length-1; // j - next position after i, k last position from the rnd.
            while(j<k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == target) return temp;
                else if (temp > target) k--;
                else j++;
                if (Math.abs(target - temp) < Math.abs(target - res)) {
                    res = temp;
                }
            }
        }
        return res;
    }
}

