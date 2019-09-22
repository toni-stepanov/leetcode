package array.three_sum_15;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = s.threeSum(a);
        for (List  l: res) {
            System.out.println(l.toString());
        }
    }
}
