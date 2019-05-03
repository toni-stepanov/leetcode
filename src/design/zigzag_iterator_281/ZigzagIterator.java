package design.zigzag_iterator_281;

import java.util.ArrayList;
import java.util.List;

/*
281. Zigzag Iterator
https://leetcode.com/problems/zigzag-iterator/

Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
 */
// Good solutions
// https://discuss.leetcode.com/topic/26654/simple-java-solution-for-k-vector
public class ZigzagIterator {

    private List<Integer> l1;
    private List<Integer> l2;
    private int current;
    private int l1Cursor;
    private int l2Cursor;

    ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l1 = (v1 == null) ? new ArrayList<>() : v1;
        l2 = (v2 == null) ? new ArrayList<>() : v2;
        current = 0;
        l1Cursor = 0;
        l2Cursor = 0;
    }

    public int next() {
        int result = Integer.MIN_VALUE;
        if (current == 0) {
            if (l1Cursor < l1.size()) {
                result = l1.get(l1Cursor);
                l1Cursor++;
                current = 1;
            } else if (l2Cursor < l2.size()) {
                result = l2.get(l2Cursor);
                l2Cursor++;
                current = 0;
            }
        } else {
            if (l2Cursor < l2.size()) {
                result = l2.get(l2Cursor);
                l2Cursor++;
                current = 0;
            } else if (l1Cursor < l1.size()) {
                result = l1.get(l1Cursor);
                l1Cursor++;
                current = 1;
            }
        }
        return result;
    }

    boolean hasNext() {
        return (l1Cursor < l1.size() || l2Cursor < l2.size());
    }
}

/*
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */