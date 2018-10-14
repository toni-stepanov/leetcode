package linked_list.merge_two_sorted_lists_21;

/*
21. Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {


    // Time complexity O(n+m), n - l1 len, m - l2 len.
    // https://discuss.leetcode.com/topic/4480/clean-simple-o-n-m-c-solution-without-dummy-head-and-recurtion
    // Great recursive solution
    // https://discuss.leetcode.com/topic/45002/java-1-ms-4-lines-codes-using-recursion
    // https://discuss.leetcode.com/topic/5513/my-recursive-way-to-solve-this-problem-java-easy-understanding

    ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // Validation;
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Set head of new list;
        ListNode res = new ListNode(-1);

        ListNode current = res;
        while (l1 != null || l2 != null) {
            int val1 = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int val2 = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        return res.next;
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1, p2 = l1, p3 = l1, p4 = l2;
        if (l1.val <= l2.val) {
            p2 = l1.next;
            p3 = l1;
        } else {
            p1 = l2;
            p3 = l2;
            p4 = p4.next;
        }
        while (p2 != null) {
            if (p4 == null) {
                p3.next = p2;
                return p1;
            }
            if (p2.val < p4.val) {
                p3.next = p2;
                p3 = p2;
                p2 = p2.next;

            } else {
                p3.next = p4;
                p3=p4;
                p4 = p4.next;
            }
        }
        p3.next = p4;
        return p1;
    }
}