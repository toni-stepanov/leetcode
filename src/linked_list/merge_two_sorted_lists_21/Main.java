package linked_list.merge_two_sorted_lists_21;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);

//        // first list
//        a.next = b;
//        b.next = c;
//
//        // second list
//        d.next = e;
//        e.next = f;
        Solution s = new Solution();
        ListNode result = s.mergeTwoLists(e,a);
        System.out.print(result);
    }
}
