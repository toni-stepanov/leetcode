package string.implementStrStr_28;

/*
28. Implement strStr()
https://leetcode.com/problems/implement-strstr/

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    // Good solution
    // https://discuss.leetcode.com/topic/18839/elegant-java-solution
    // n - haystack length, m - needle length;
    // Time complexity O(n*m) space complexity just for init data - O(n*m)
    public int strStr1(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (needleLen > haystackLen) return -1;
        if (needleLen == 0) return 0;
        Character nFirst = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == nFirst) {
                if (needleLen == 1) return i;
                boolean found = true;
                for (int j = 1; j < needleLen; j++) {
                    if (i + j >= haystackLen || haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) return i;
            }
        }
        return -1;
    }


    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int i = 0;
        int startIndex = 0;
        int needleIndex = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i)
                    == needle.charAt(needleIndex)) {
                if (needleIndex == needle.length() - 1) {
                    return startIndex;
                }
                needleIndex++;
                i++;
            } else {
                startIndex++;
                i = startIndex;
                needleIndex = 0;
            }
        }
        return -1;
    }

    // another option -Boyer–Moore–Horspool algorithm  https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore%E2%80%93Horspool_algorithm
    // https://www.youtube.com/watch?v=PHXAOKQk2dw
}