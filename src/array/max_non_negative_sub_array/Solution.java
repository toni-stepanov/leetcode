package array.max_non_negative_sub_array;

import java.util.ArrayList;

/**

 */
public class Solution {
    ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long maxSum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null || a.size() == 0) return res;
        long sum = 0;
        ArrayList<Integer> current = new ArrayList<>();
        for (Integer anA : a) {
            int i = anA;
            if (i < 0) {
                if (sum > maxSum || (sum == maxSum && current.size() > res.size())) {
                    res = new ArrayList<>(current);
                    maxSum = sum;
                }
                sum = 0;
                current = new ArrayList<>();
            } else {
                sum += i;
                current.add(i);
            }
        }
        if (sum > maxSum || (sum == maxSum && current.size() > res.size())) {
            res = new ArrayList<>(current);
        }
        return res;
    }
}