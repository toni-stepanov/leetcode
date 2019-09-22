package linked_list.copy_list_with_random_pointer_138;

class Node {
    public int val;
    public Node next;
    Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};