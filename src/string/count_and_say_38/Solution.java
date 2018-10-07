package string.count_and_say_38;

/*
38. Count and Say
https://leetcode.com/problems/count-and-say/

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Subscribe to see which companies asked this question
*/
// https://discuss.leetcode.com/topic/2264/examples-of-nth-sequence - explanation what is nth sequence.
// Good solutions using recursion
// https://discuss.leetcode.com/topic/41718/my-simple-java-solution/2
// https://discuss.leetcode.com/topic/20195/c-solution-easy-understand
public class Solution {

    // Time complexity ?, space complexity ?
    String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String ret = "1";
        for (int i = 1; i < n; i++) {
            char c = ret.charAt(0);
            int counter = 1;
            StringBuilder newRet = new StringBuilder();
            for (int j = 1; j < ret.length(); j++) {
                if (c == ret.charAt(j)) {
                    counter++;
                } else {
                    newRet.append(counter).append(String.valueOf(c));
                    counter = 1;
                    c = ret.charAt(j);
                }
            }
            if (counter != 0) {
                newRet.append(counter).append(String.valueOf(c));
            }
            if (!newRet.toString().equals("")) {
                ret = newRet.toString();
            }
        }
        return ret;
    }
}