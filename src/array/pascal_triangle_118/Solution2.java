package array.pascal_triangle_118;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows > 0) {
            List<Integer> first = new ArrayList<>();
            first.add(1);
            ret.add(first);
            List<Integer> cur = new ArrayList<>(), prev;
            for (int i = 1; i < numRows; i++) {
                prev = cur;
                cur = new ArrayList<>();
                cur.add(1);
                for (int j = 0; j < i - 1; j++) {
                    cur.add(prev.get(j) + prev.get(j + 1));
                }
                cur.add(1);
                ret.add(cur);
            }
        }
        return ret;
    }

}
