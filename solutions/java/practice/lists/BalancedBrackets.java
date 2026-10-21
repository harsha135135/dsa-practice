package practice.lists;

import java.util.ArrayDeque;
import java.util.Deque;

/** Reference solution for exercise 3.3: a stack of the opening brackets still waiting to be closed. */
public final class BalancedBrackets {

    private BalancedBrackets() {
    }

    public static boolean isBalanced(String text) {
        Deque<Character> open = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            switch (c) {
                case '(', '[', '{' -> open.push(c);
                case ')', ']', '}' -> {
                    if (open.isEmpty() || open.pop() != matchingOpen(c)) {
                        return false;
                    }
                }
                default -> {
                    // not a bracket: ignore
                }
            }
        }
        return open.isEmpty();
    }

    private static char matchingOpen(char close) {
        return switch (close) {
            case ')' -> '(';
            case ']' -> '[';
            default -> '{';
        };
    }
}
