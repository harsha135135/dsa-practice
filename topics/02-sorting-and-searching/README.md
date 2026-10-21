# Topic 2: sorting, binary search, two pointers, sliding windows

## Ideas to know

- **Merge sort:** split in half, sort each half, merge. Always O(n log n).
- **Binary search:** in sorted data, look at the middle and throw away the half that cannot hold the answer. O(log n).
- **Binary search on the answer:** if "is x enough?" turns from no to yes exactly once as x grows, binary search finds the first yes.
- **Two pointers:** in sorted data, one pointer at each end moving inwards replaces a loop inside a loop.
- **Sliding window:** a run `[left, right]` that grows on the right and shrinks on the left, never going backwards.

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build merge sort](1-build-merge-sort.md) | build it | `MergeSort` |
| 2 | [First and last position](2-first-and-last.md) | warm-up | `FirstAndLast` |
| 3 | [Three sum](3-three-sum.md) | standard | `ThreeSum` |
| 4 | [Ship capacity](4-ship-capacity.md) | harder | `ShipCapacity` |
| 5 | [Shortest window with every kind](5-later-shortest-window.md) | do it **at least a week later** | `ShortestWindow` |

Your code goes in `src/main/java/practice/searching/`. Run one exercise's tests with
`./mvnw test -Dtest=<Class>Test`.
