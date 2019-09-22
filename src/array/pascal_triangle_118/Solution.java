package array.pascal_triangle_118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5, Return:
 * [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 https://en.wikipedia.org/wiki/Pascal's_triangle
 https://discuss.leetcode.com/topic/5128/solution-in-java
 https://discuss.leetcode.com/topic/6805/my-concise-solution-in-java
 */
public class Solution {

    List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Collections.singletonList(1));
        if (numRows == 1) {
            return ret;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            int curVal = 0;
            for (int val : ret.get(i - 1)) {
                cur.add(val + curVal);
                curVal = val;
            }
            cur.add(1);
            ret.add(cur);
        }
        return ret;
    }


//    List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ret = new ArrayList<>();
//        if (numRows <= 0) {
//            return ret;
//        } else {
//            ret.add(Collections.singletonList(1));
//            for (int i = 1; i < numRows; i++) {
//                ArrayList<Integer> currList = new ArrayList<>();
//                List<Integer> upperList = ret.get(i-1);
//                for (int j = 0; j <= i; j++) {
//                    int value = 0;
//                    if ((j - 1) >= 0) {
//                        value += upperList.get(j - 1);
//                    }
//                    if (upperList.size() > j) {
//                        value += upperList.get(j);
//                    }
//                    currList.add(value);
//                }
//                ret.add(currList);
//            }
//        }
//        return ret;
//    }
}
