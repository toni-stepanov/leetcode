package linked_list.reverse_linked_list_206;

/*
206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/

Reverse a singly linked list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
    // Time complexity O(n), space complexity O(1)
    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = null;
        ListNode p2 = head;
        while (p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        return p1;
    }

    // Great iterative and recursive solutions
    // https://discuss.leetcode.com/topic/13268/in-place-iterative-and-recursive-java-solution
    ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        return reverseListRecursive(null, head);
    }

    ListNode reverseListRecursive(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        ListNode newHead = head.next;
        head.next = prev;
        return reverseListRecursive(head, newHead);
    }
}