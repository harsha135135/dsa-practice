# 6.3 Course order (standard)

**Write it in:** `src/main/java/practice/graphs/CourseOrder.java` · **Test:** `./mvnw test -Dtest=CourseOrderTest`

## Problem

There are `n` courses, `0` to `n − 1`. Each pair `{course, first}` means `first` must be taken before `course`.
Return an order to take all courses. When several courses are ready, always take the **smallest-numbered** one next
(this makes the answer unique). If it is impossible (some courses wait on each other in a circle), return an empty list.

## Examples

| n | pairs | answer |
|---|---|---|
| 4 | `{1,0} {2,0} {3,1} {3,2}` | `[0, 1, 2, 3]` |
| 3 | `{0,2}` | `[1, 2, 0]` |
| 2 | `{0,1} {1,0}` | `[]` |

## Limits

Random inputs are checked against a slow "scan for the smallest ready course" method.

## Hints

<details><summary>Hint 1: a nudge</summary>

A course is ready when all of its prerequisites are done. How could you track that without rechecking everything?
</details>

<details><summary>Hint 2: the approach</summary>

For each course, count its **unmet** prerequisites, and keep, for each course, the list of courses it unlocks. Ready courses have count 0.
</details>

<details><summary>Hint 3: almost the answer</summary>

Put ready courses in a `PriorityQueue` (smallest first). Take one, add it to the order, and lower the count of everything it unlocks; any that reach 0 become ready. If the order is shorter than `n`, there is a cycle.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/06-graphs/course-order.md`.
