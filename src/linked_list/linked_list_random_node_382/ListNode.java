package linked_list.linked_list_random_node_382;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val + "->");
            current = current.next;
        }
        return sb.toString();
    }
}
