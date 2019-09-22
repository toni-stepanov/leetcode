package linked_list.merge_k_sorted_lists_23;

/*
23. Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/

Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.
*/

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // https://leetcode.com/problems/merge-k-sorted-lists/solution/
    // Approach 1
    ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<>();
        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }
        Collections.sort(l);
        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i : l) {
            h.next = new ListNode(i);
            h = h.next;
        }
        h.next = null;
        return head.next;
    }

    // Approach 2: Compare one by one
    //    O(1) space
    public ListNode mergeKLists2_1(ListNode[] lists) {
        int minIndex = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        minIndex = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }
            }
            if (isBreak) {
                break;
            }
            h.next = lists[minIndex];
            h = h.next;
            lists[minIndex] = lists[minIndex].next;
        }
        h.next = null;
        return head.next;
    }

    //    Approach 3: Optimize Approach 2 by Priority Queue
    // Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.
    // O(n)O(n) Creating a new linked list costs O(n)O(n) space.
    // O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations).
    ListNode mergeKLists3(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                queue.add(next);
            }
        }
        return head.next;
    }

    //    Approach 4: Merge lists one by one
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 0) {
            return null;
        }
        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    //    Approach 5: Merge with Divide And Conquer
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            h.next = l2;
        }
        if (l2 == null) {
            h.next = l1;
        }
        return ans.next;
    }

    public ListNode mergeKLists5(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

}