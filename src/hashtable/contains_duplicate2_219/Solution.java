package hashtable.contains_duplicate2_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
219. Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/

Given an array of integers and an integer k, find out whether
there are two distinct indices i and j in the array such that
nums[i] = nums[j] and the difference between i and j is at most k.
*/
// Time complexity O(n), space complexity O(n).
public class Solution {

    boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (i - index <= k) return true;
                map.remove(nums[i]);
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k < 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Integer saved = map.get(current);
            if (saved != null && Math.abs(i - saved) <= k) return true;
            map.put(current, i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
// Great solution
// https://discuss.leetcode.com/topic/15305/simple-java-solution
// The basic idea is to maintain a set s which contain unique values from nums[i - k] to nums[i - 1],
// if nums[i] is in set s then return true else update the set.
// So we can reduce space complexity to store only k items maximum in a hashmap.
// And we can use HashSet in this case.