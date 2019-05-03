package string.valid_parentheses_20;

import java.util.Stack;

/*
20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i< s.length(); i++) {
            switch(s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}