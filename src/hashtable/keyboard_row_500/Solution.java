package hashtable.keyboard_row_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 500. Keyboard Row
 * https://leetcode.com/problems/keyboard-row/#/description
 * <p>
 * Given a List of words, return the words that can be typed using letters of alphabet
 * on only one row's of American keyboard like the image below.
 * <p>
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * <p>
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
// https://discuss.leetcode.com/topic/77773/short-easy-java-with-explanation
public class Solution {
    String[] findWords(String[] words) {
        String[] rows = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < rows.length; r++) {
            for (char c : rows[r].toCharArray()) {
                map.put(c, r);
            }
        }
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (w.length() == 0) continue;
            int row = map.get(Character.toUpperCase(w.charAt(0)));
            boolean isOneRow = true;
            for (char c : w.toUpperCase().toCharArray()) {
                if (map.get(c) != row) {
                    isOneRow = false;
                    break;
                }
            }
            if (isOneRow) res.add(w);
        }
        return res.toArray(new String[0]);
    }
}