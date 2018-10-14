package linked_list.palindrome_linked_list_234;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);
        a.next = b;
        b.next = null;
        c.next = d;
        d.next = e;
        e.next = f;
        Solution s = new Solution();
        boolean result = s.isPalindrome(a);
        System.out.print(result);
    }
}
