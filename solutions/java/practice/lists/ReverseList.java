package practice.lists;

/** Reference solution for exercise 3.2: walk the list once, turning each arrow around. */
public final class ReverseList {

    /** One link in a singly linked list. */
    public static final class Node {
        public final int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private ReverseList() {
    }

    public static Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next; // remember the rest before overwriting the link
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
