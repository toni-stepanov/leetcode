package linked_list.convert_sorted_list_to_bst_109;

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
