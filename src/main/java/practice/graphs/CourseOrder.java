package practice.graphs;

import java.util.List;

/** Exercise 6.3: see topics/06-graphs/3-course-order.md */
public final class CourseOrder {

    private CourseOrder() {
    }

    /**
     * An order to take courses 0..n-1 so each comes after its prerequisites, always taking the
     * smallest-numbered course that is ready. Empty list if impossible.
     * Each prerequisite pair is {course, mustComeFirst}.
     */
    public static List<Integer> order(int n, int[][] prerequisites) {
        throw new UnsupportedOperationException("not solved yet");
    }
}
