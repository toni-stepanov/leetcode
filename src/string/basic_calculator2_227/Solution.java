package string.basic_calculator2_227;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
227. Basic Calculator II
https://leetcode.com/problems/basic-calculator-ii/

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/
public class Solution {
    // Time complexity O(n)
    //https://discuss.leetcode.com/topic/16935/share-my-java-solution
    int calculate(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        if (len == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            Character curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                currentNum = currentNum * 10 + curr - '0';
            }
            if (!Character.isDigit(curr) || i == len - 1) {
                switch (sign) {
                    case '+':
                        stack.push(currentNum);
                        break;
                    case '-':
                        stack.push(-currentNum);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNum);
                        break;
                    case '/':
                        stack.push(stack.pop() / currentNum);
                        break;
                }
                sign = curr;
                currentNum = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }

}