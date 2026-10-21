package practice.lists;

/** Exercise 3.2: see topics/03-lists-stacks-queues/2-reverse-list.md */
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

    /** Reverses the list starting at {@code head} and returns the new head. */
    public static Node reverse(Node head) {
        throw new UnsupportedOperationException("not solved yet");
    }
}
