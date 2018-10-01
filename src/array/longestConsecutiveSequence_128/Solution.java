package array.longestConsecutiveSequence_128;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
public class Solution {
    int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int i : nums) {
            // check that current item is the beginning of the sequence -> no element before current.
            if (!set.contains(i - 1)) {
                int j = i;
                while (set.contains(j)) {
                    j++;
                }
                ;
                max = Math.max(max, j - i);
            }
        }
        return max;
    }
}
