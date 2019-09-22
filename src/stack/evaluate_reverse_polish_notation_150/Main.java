package stack.evaluate_reverse_polish_notation_150;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] n = new String[] {"2", "1", "+", "3", "*"};
        int result = s.evalRPN(n) ;
        System.out.println(result);
    }
}