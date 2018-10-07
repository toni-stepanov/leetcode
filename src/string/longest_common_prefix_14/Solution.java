package string.longest_common_prefix_14;

/*
14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    // Time complexity O(m*n)
    String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index =0;
        while (index < strs[0].length()) {
            if (!isCommon(strs, strs[0].charAt(index), index)) {
                break;
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    boolean isCommon(String[] strs, char c, int i) {
        for (String s: strs) {
            if(s.length() <= i || s.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }
}
