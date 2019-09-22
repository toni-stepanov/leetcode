package hashtable.group_anagrams_49;

import java.util.*;

/*
49. Group Anagrams
https://leetcode.com/problems/anagrams/

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/
public class Solution {

    // n - strs length, m - max word length
    // Space complexity - O(n*m + n*m) => O(m*n) - first n*m - List<String> in the map, second - keys.
    // Time complexity - O(n*m*log m)
    // https://discuss.leetcode.com/topic/24494/share-my-short-java-solution
    List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}