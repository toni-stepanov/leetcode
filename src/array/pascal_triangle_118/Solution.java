package array.pascal_triangle_118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows <= 0) {
            return ret;
        } else {
            ret.add(Collections.singletonList(1));
            for (int i = 1; i < numRows; i++) {
                ArrayList<Integer> currList = new ArrayList<>();
                List<Integer> upperList = ret.get(i-1);
                for (int j = 0; j <= i; j++) {
                    int value = 0;
                    if ((j - 1) >= 0) {
                        value += upperList.get(j - 1);
                    }
                    if (upperList.size() > j) {
                        value += upperList.get(j);
                    }
                    currList.add(value);
                }
                ret.add(currList);
            }
        }
        return ret;
    }
}
