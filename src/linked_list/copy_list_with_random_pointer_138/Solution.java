package linked_list.copy_list_with_random_pointer_138;

/*
138. Copy List with Random Pointer
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 * class Node {
 *     int label;
 *     Node next, random;
 *     Node(int x) { this.label = x; }
 * };
 */
public class Solution {

    Node copyRandomList2(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val, null, null));
            node = node.next;
        }
        map.forEach((k, v) -> {
            v.next = map.get(k.next);
            v.random = map.get(k.random);
        });

        return map.get(head);
    }

    Node copyRandomList(Node head) {
        if (head==null) return null;
        // loop#1
        // creates a new node and incorporates it with the 'next' field of the source node.
        // And the 'next' field of the new node points to next source node.
        Node curr = head;
        while(curr != null){
            Node clone = new Node();
            Node tmp = curr.next;
            curr.next = clone;
            clone.next = tmp;
            curr = tmp;
        }

        // loop#2- populate clone's random field.
        curr = head;
        while(curr != null && curr.next != null){
            Node clone = curr.next;
            clone.val = curr.val;
            if (curr.random != null){
                clone.random = curr.random.next;
            }
            curr = clone.next;
        }

        // loop#3- separate the target list from the source list.
        curr = head;
        Node newHead = curr.next;
        Node newCurr = curr.next;
        while(curr != null && curr.next != null){
            curr.next = newCurr.next;
            if (newCurr.next != null){
                newCurr.next = curr.next.next;
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}