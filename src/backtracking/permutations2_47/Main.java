package backtracking.permutations2_47;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.permuteUnique(new int[]{1, 1, 1, 2});
        for(List<Integer> l : result) {
            System.out.println(l);
        }
    }
}
