package design.rbt;

/**
 * Node implementation
 */
class Node<Key extends Comparable<Key>, Value> {
    static final boolean RED = true;
    static final boolean BLACK = false;

    Node(Key key, Value value, boolean color) {
        this.key = key;
        this.value = value;
        this.count = 1;
        this.color = color;
    }

    Key key;
    Value value;
    Node<Key, Value> left;
    Node<Key, Value> right;
    boolean color;
    int count;

    @Override
    public String toString() {
        return key + " " + value + " " + count;
    }
}
