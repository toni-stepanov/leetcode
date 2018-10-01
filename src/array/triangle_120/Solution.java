package array.triangle_120;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Solution {

    int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> result = new ArrayList<>(triangle.get(triangle.size() - 1));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(triangle.size() - i - 1);
            for (int j = 0; j < level.size(); j++) {
                int value = level.get(j) + Math.min(result.get(j), result.get(j + 1));
                result.set(j, value);
            }
        }
        return result.get(0);
    }

}