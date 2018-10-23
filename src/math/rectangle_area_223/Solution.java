package math.rectangle_area_223;

/*
223. Rectangle Area
https://leetcode.com/problems/rectangle-area/

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Assume that the total area is never beyond the maximum possible value of int.
*/
public class Solution {
    // Good solution with max and min
    // https://discuss.leetcode.com/topic/15648/an-easy-to-understand-solution-in-java
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sq1 = getArea(A, B, C, D);
        int sq2 = getArea(E, F, G, H);
        if (sq1 == 0 || sq2 == 0) {
            return sq1 + sq2;
        }
        // if no intersection
        if (C < E || G < A || H < B || D < F) {
            return sq1 + sq2;
        }
        int w = Math.min(C,G) - Math.max(A,E);
        int h = Math.min(H,D) - Math.max(B,F);
        return sq1+sq2-w*h;
    }

    private int getArea(int x1, int y1, int x2, int y2) {
        return (x2-x1) * (y2-y1);
    }
}
