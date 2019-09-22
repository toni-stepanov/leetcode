package string.longest_substring_with_at_most_two_distinct_characters_159;

import java.util.HashMap;
import java.util.Map;

/*
159. Longest Substring with At Most Two Distinct Characters
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/

Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/
public class Solution {
    int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1) return 0;
        HashMap<Character, Integer> index = new HashMap<>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while (hi < s.length()) {
            if (index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if (index.size() > 2) {
                int leftMost = s.length();
                for (int i : index.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost + 1;
            }
            maxLength = Math.max(maxLength, hi - lo);
        }
        return maxLength;
    }

    // two pointers
    int lengthOfLongestSubstringTwoDistinct2(String source) {
        char[] s = source.toCharArray();
        int[] freq = new int[256];
        int len = 0;
        int r = 0;
        int k = 2;
        for (int l = 0; l < s.length; ++l) {
            while (r < s.length) {
                char c = s[r];
                if (freq[c] > 0) {
                    ++freq[c];
                } else if (k > 0) {
                    ++freq[c];
                    --k;
                } else {
                    break;
                }
                ++r;
            }
            len = Math.max(len, r - l);
            if (k == 0) {
                char c = s[l];
                --freq[c];
                if (freq[c] == 0) {
                    ++k;
                }
            }
        }
        return len;
    }
}