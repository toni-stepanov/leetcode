package array.pascal_119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    /**
     * 119. Pascal's Triangle 2
     * https://leetcode.com/problems/pascals-triangle-ii/
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     * Note that the row index starts from 0.
     */
    List<Integer> getRow(int numRows) {
        if (numRows < 0) {
            return new ArrayList<>();
        }
        List<Integer> cur = Collections.singletonList(1);
        if (numRows == 0) {
            return cur;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> prev = cur;
            cur = new ArrayList<>();
            int curVal = 0;
            for (int val : prev) {
                cur.add(val + curVal);
                curVal = val;
            }
            cur.add(1);
        }
        return cur;
    }

}
