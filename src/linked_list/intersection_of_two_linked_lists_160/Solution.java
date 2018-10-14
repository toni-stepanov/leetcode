package linked_list.intersection_of_two_linked_lists_160;

/*
160. Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Time complexity O(m+n)
    // get lengths, find diffs, while != each other
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode small, big;
        if (lengthA > lengthB) {
            small = headB;
            big = headA;
        } else {
            small = headA;
            big = headB;
        }
        int diff = Math.abs(lengthA - lengthB);
        while (diff > 0) {
            diff--;
            big = big.next;
        }
        while (big != small && big != null) {
            big = big.next;
            small = small.next;
        }
        return big;
    }

    int getLength(ListNode node) {
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    // Great solution from here
    // https://discuss.leetcode.com/topic/28067/java-solution-without-knowing-the-difference-in-len
    // say A length = a + c, B length = b + c, after switching pointer,
    // pointer A will move another b + c steps, pointer B will move a + c more steps,
    // since a + c + b + c = b + c + a + c, it does not matter what value c is.
    // Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            System.out.println("a=" + (a!=null ? a.val : "NULL"));
            System.out.println("b=" + (b!=null ? b.val : "NULL"));
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }*/
}