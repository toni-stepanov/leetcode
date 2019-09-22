package array.maximum_distance_in_arrays_624;

import java.util.List;

/**
 624. Maximum Distance in Arrays
 https://leetcode.com/problems/maximum-distance-in-arrays/#/description

 Given m arrays, and each array is sorted in ascending order. Now you can pick up
 two integers from two different arrays (each array picks one) and calculate the distance.
 We define the distance between two integers a and b to be their absolute difference |a-b|.
 Your task is to find the maximum distance.

 Example 1:
 Input:
 [[1,2,3],
 [4,5],
 [1,2,3]]
 Output: 4
 Explanation:
 One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 Note:
 Each given array will have at least 1 number. There will be at least two non-empty arrays.
 The total number of the integers in all the m arrays will be in the range of [2, 10000].
 The integers in the m arrays will be in the range of [-10000, 10000].
 */

public class Solution {
    // Good solution
    // https://discuss.leetcode.com/topic/92847/share-my-o-n-solution
    int maxDistance(List<List<Integer>> arrays) {
        int diff = Integer.MIN_VALUE;
        int min = getFirst(arrays.get(0));
        int max = getLast(arrays.get(0));
        for (int i=1; i<arrays.size(); i++) {
            List<Integer> currList = arrays.get(i);
            int currMin = getFirst(currList);
            int currMax = getLast(currList);
            // check cross diffs
            diff = Math.max(diff, Math.abs(max - currMin));
            diff = Math.max(diff, Math.abs(currMax - min));
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
        }
        return diff;
    }

    private int getFirst(List<Integer> list) {
        return list.get(0);
    }

    private int getLast(List<Integer> list) {
        return list.get(list.size()-1);
    }
 }