package hashtable.longest_substring_without_repeating_characters_3;

import java.util.HashMap;
import java.util.Map;

/*
3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without
repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that
the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class Solution {

    // Time complexity O(n), space complexity O(n)
    // https://discuss.leetcode.com/topic/8232/11-line-simple-java-solution-o-n-with-explanation
    // https://discuss.leetcode.com/topic/24739/c-code-in-9-lines
    int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 1;
        for(int right = 0; right<s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // do not use just left = map.get(c)+1; try s="abba"
                // because of we don`t clean the map, when right is last a, we should set the left to 2nd b,
                // instead of 1st a.
                left = Math.max(left, map.get(c)+1);
            }
            map.put(c, right);
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}