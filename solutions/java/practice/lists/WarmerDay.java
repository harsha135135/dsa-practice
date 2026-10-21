package practice.lists;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Reference solution for exercise 3.5: a stack of days still waiting for a warmer day.
 * Their temperatures never increase from the bottom to the top of the stack.
 */
public final class WarmerDay {

    private WarmerDay() {
    }

    public static int[] daysToWait(int[] temperatures) {
        int[] wait = new int[temperatures.length];
        Deque<Integer> waitingDays = new ArrayDeque<>();
        for (int today = 0; today < temperatures.length; today++) {
            while (!waitingDays.isEmpty() && temperatures[waitingDays.peek()] < temperatures[today]) {
                int day = waitingDays.pop();
                wait[day] = today - day; // today is the first warmer day for `day`
            }
            waitingDays.push(today);
        }
        return wait; // days still on the stack never got a warmer day: they stay 0
    }
}
