package array.missing_ranges_163;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 * https://leetcode.com/problems/missing-ranges/
 * <p>
 * Given a sorted integer array where the range of elements are in the
 * inclusive range [lower, upper], return its missing ranges.
 * <p>
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * return ["2", "4->49", "51->74", "76->99"].
 */
public class Solution {

    List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            String s = (lower == upper) ? lower + "" : lower + "->" + upper;
            result.add(s);
            return result;
        }
        addRange(lower, true, nums[0], false, result);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            addRange(prev, false, nums[i], false, result);
            prev = nums[i];
        }
        addRange(prev, false, upper, true, result);
        return result;
    }

    private void addRange(int lower, boolean includeLower, int upper, boolean includeUpper, ArrayList<String> result) {
        if (lower == upper) return;
        if (upper - lower == 1) {
            if (includeLower) result.add(lower + "");
            else if (includeUpper) result.add(upper + "");
        } else if (upper - lower == 2) {
            if (includeLower) result.add(lower + "->" + (upper - 1));
            else if (includeUpper) result.add(lower + 1 + "->" + upper);
            else result.add(upper - 1 + "");
        } else { // upper - lower > 2
            if (includeLower) result.add(lower + "->" + (upper - 1));
            else if (includeUpper) result.add(lower + 1 + "->" + upper);
            else result.add(lower + 1 + "->" + (upper - 1));
        }
    }
}