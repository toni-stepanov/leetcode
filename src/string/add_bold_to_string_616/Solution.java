package string.add_bold_to_string_616;

/*
616. Add bold to string
https://leetcode.com/problems/add-bold-tag-in-string/

Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the
substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair
of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:
Input:
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
*/
class Solution {
    String addBoldTag(String S, String[] words) {
        int length = S.length();
        boolean[] mask = new boolean[length];
        for (int i = 0; i < length; ++i) {
            for (String word : words)
                search:{
                    for (int k = 0; k < word.length(); ++k)
                        if (k + i >= S.length() || S.charAt(k + i) != word.charAt(k))
                            break search;

                    for (int j = i; j < i + word.length(); ++j)
                        mask[j] = true;
                }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            if (mask[i] && (i == 0 || !mask[i - 1]))
                ans.append("<b>");
            ans.append(S.charAt(i));
            if (mask[i] && (i == length - 1 || !mask[i + 1]))
                ans.append("</b>");
        }
        return ans.toString();
    }

}