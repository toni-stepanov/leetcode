package string.remove_invalid_parentheses_301;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.removeInvalidParentheses("()())()");
        System.out.println(result);
    }
}
