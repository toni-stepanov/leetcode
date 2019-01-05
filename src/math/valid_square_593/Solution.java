package math.valid_square_593;

import java.util.HashSet;

/*

Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.
*/
class Solution {

    boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>();
        set.add(distance(p1, p2));
        set.add(distance(p1, p3));
        set.add(distance(p1, p4));
        set.add(distance(p2, p3));
        set.add(distance(p2, p4));
        set.add(distance(p3, p4));
        return !set.contains(0) && set.size() == 2;
    }

    private int distance(int [] first, int[] second) {
        return (first[0] - second[0])*(first[0] - second[0]) + (second[1] - first[1])*(second[1] - first[1]);
    }

}