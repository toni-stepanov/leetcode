package hashtable.word_pattern_290;

import java.util.HashMap;

/*
290. Word Pattern
https://leetcode.com/problems/word-pattern/
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class Solution {

    boolean wordPattern2(String pattern, String str) {
        String[] words = str.split("\\s+");
        if (words.length != pattern.length()) {
            return false;
        }
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char patternVal = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(word)) {
                if (map.get(word) != patternVal) {
                    return false;
                }
            } else if (!map.containsValue(patternVal)) {
                map.put(word, patternVal);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s+");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String word = words[i];
            Character currentChar = pattern.charAt(i);
            if (!map.containsKey(currentChar) && !map.containsValue(word)) {
                map.put(currentChar, word);
            } else {
                String savedWord = map.get(currentChar); // savedWord can be null.
                if (!word.equals(savedWord)) return false;
            }
        }
        return true;
    }
}
