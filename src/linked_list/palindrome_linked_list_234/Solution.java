package linked_list.palindrome_linked_list_234;

/*
234. Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
    boolean isPalindrome(ListNode head) {
        ListNode p1 = null, p2=head, p3=head;
        while(p3 != null && p3.next != null) {
            p3 = p3.next.next;
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        if (p3 != null) {
            p2 = p2.next;
        }
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
