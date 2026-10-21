package practice.lists;

import org.junit.jupiter.api.Test;
import practice.lists.ReverseList.Node;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseListTest {

    private static Node listOf(int... values) {
        Node head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
        return head;
    }

    private static List<Integer> toList(Node head) {
        List<Integer> values = new ArrayList<>();
        for (Node node = head; node != null; node = node.next) {
            values.add(node.value);
        }
        return values;
    }

    @Test
    void examples() {
        assertEquals(List.of(5, 4, 3, 2, 1), toList(ReverseList.reverse(listOf(1, 2, 3, 4, 5))));
        assertEquals(List.of(2, 1), toList(ReverseList.reverse(listOf(1, 2))));
        assertEquals(List.of(7), toList(ReverseList.reverse(listOf(7))));
        assertNull(ReverseList.reverse(null));
    }

    @Test
    void reusesTheSameNodesInsteadOfCopying() {
        Node head = listOf(1, 2, 3);
        Node last = head.next.next;

        assertEquals(last, ReverseList.reverse(head));
        assertNull(head.next, "the old head is now the end");
    }

    @Test
    void longListDoesNotOverflowTheStack() {
        int[] values = new int[200_000];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        assertEquals(199_999, ReverseList.reverse(listOf(values)).value);
    }
}
