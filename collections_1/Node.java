package collections_1;

public class Node {
    Object item;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(Object item, Node prev, Node next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }
}