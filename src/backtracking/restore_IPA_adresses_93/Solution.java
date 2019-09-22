package backtracking.restore_IPA_adresses_93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
93. Restore IP Addresses
https://leetcode.com/problems/restore-ip-addresses/#/description

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public class Solution {
    private List<String> result = new LinkedList<>();

    List<String> restoreIpAddresses(String s) {
        if (s == null) return result;
        backtrack(0, new ArrayList<>(), s);
        return result;
    }

    private void backtrack(int index, List<String> current, String str) {
        if (current.size() == 4) {
            if (index == str.length()) {
                String ip = String.join(".", current);
                result.add(ip);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int nextIndex = index + i;
            if (nextIndex <= str.length()) {
                String section = str.substring(index, nextIndex);
                if (isSectionValid(section)) {
                    current.add(section);
                    backtrack(nextIndex, current, str);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    private boolean isSectionValid(String section) {
        return section.length() != 0 && section.length() <= 3 &&
                (!section.startsWith("0") || section.length() <= 1) && (Integer.valueOf(section) < 256);
    }
}