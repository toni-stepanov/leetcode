package linked_list.swap_nodes_in_pairs_24;

/*
24. Swap Nodes in Pairs
https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list,
 only nodes itself can be changed.
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
    // Time complexity O(n), space complexity O(n) - because recursion affects the stack.
    // https://discuss.leetcode.com/topic/10649/my-simple-java-solution-for-share/2 - not recursive solution
    ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode ret = head.next;
        ListNode prev = null;
        while (p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1.next = t;
            if (prev != null) {
                prev.next = p2;
            }
            prev = p1;
            p1 = t;
            if (p1 != null) {
                p2 = p1.next;
            } else {
                p2 = null;
            }
        }
        return ret;
    }
}