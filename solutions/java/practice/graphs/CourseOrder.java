package practice.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Reference solution for exercise 6.3: Kahn's topological sort.
 *
 * <p>Count each course's unmet prerequisites. Courses with zero are ready. Take the smallest
 * ready course, and lower the count of every course that was waiting for it.
 */
public final class CourseOrder {

    private CourseOrder() {
    }

    public static List<Integer> order(int n, int[][] prerequisites) {
        List<List<Integer>> unlocks = new ArrayList<>();
        for (int course = 0; course < n; course++) {
            unlocks.add(new ArrayList<>());
        }
        int[] unmet = new int[n];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int first = pair[1];
            unlocks.get(first).add(course);
            unmet[course]++;
        }

        PriorityQueue<Integer> ready = new PriorityQueue<>(); // smallest number first
        for (int course = 0; course < n; course++) {
            if (unmet[course] == 0) {
                ready.add(course);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!ready.isEmpty()) {
            int course = ready.poll();
            order.add(course);
            for (int next : unlocks.get(course)) {
                if (--unmet[next] == 0) {
                    ready.add(next);
                }
            }
        }
        // If some courses never became ready, they wait on each other in a cycle.
        return order.size() == n ? order : List.of();
    }
}
