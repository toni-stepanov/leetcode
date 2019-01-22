package backtracking.letter_combinations_phone_number_17;

import java.util.ArrayList;
import java.util.List;

/*
17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a digit string, return all possible letter combinations that the number could represent.
*/
// Solution with no recursion
// https://discuss.leetcode.com/topic/8465/my-java-solution-with-fifo-queue
public class Solution {
    private final static String[] digitsToChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> candidates = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            candidates.add(digitsToChars[c - '0']);
        }
        List<String> result = new ArrayList<>();
        letterCombinationsFrom(candidates, new StringBuilder(), result);
        return result;
    }

    private void letterCombinationsFrom(List<String> candidates, StringBuilder curRes, List<String> result) {
        if (curRes.length() == candidates.size()) {
            result.add(curRes.toString());
            return;
        }
        String candidate = candidates.get(curRes.length());
        for (int i = 0; i < candidate.length(); i++) {
            curRes.append(candidate.charAt(i));
            letterCombinationsFrom(candidates, curRes, result);
            curRes.deleteCharAt(curRes.length() - 1);
        }
    }
}