package linked_list.linked_list_cycle_141;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b;

        Solution s = new Solution();
        boolean ret
                = s.hasCycle(a);
        System.out.print(ret);
    }
}
