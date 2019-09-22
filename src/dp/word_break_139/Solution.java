package dp.word_break_139;

import java.util.*;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/?tab=Description
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary
 * words. You may assume the dictionary does not contain duplicate words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {

    // Time complexity : O(n^n)
    // Space complexity : O(n)O(n)
    boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet(wordDict), 0);
    }

    boolean wordBreak(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    //Time complexity : O(n^2)
    //Space complexity : O(n)
    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak2(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    boolean wordBreak2(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak2(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    // Time complexity : O(n^2)
    //Space complexity : O(n)
    boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    // dp
    // Time complexity : O(n^2) Two loops are their to fill \text{dp}dp array.
    // Space complexity : O(n). Length of pp array is n+1n+1.
    public boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}