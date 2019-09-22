package linked_list.copy_list_with_random_pointer_138;

public class Main {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        a.random = e;

        b.next = c;
        c.next = d;
        d.next = e;
        e.random = a;

        Solution s = new Solution();
        Node clone = s.copyRandomList(a);

        System.out.print(clone);
    }
}
