# 5.1 Build a min-heap (build it)

**Write it in:** `src/main/java/practice/trees/MinHeap.java` · **Test:** `./mvnw test -Dtest=MinHeapTest`

## Problem

Write a min-heap of `int`s stored in an array (do not use `PriorityQueue`):
- `add(value)`
- `peek()`: the smallest value; `poll()`: remove and return it. Both throw `NoSuchElementException` when empty.
- `size()`, `isEmpty()`

`add` and `poll` must be O(log n). The array must grow when full.

## Examples

Add `5, 3, 8, 1, 9, 2, 2`, then poll seven times: `1, 2, 2, 3, 5, 8, 9`.

## Limits

20,000 random steps are compared with `PriorityQueue`.

## Hints

<details><summary>Hint 1: a nudge</summary>

Picture a tree filled level by level, left to right, stored in an array. Where are the children of index `i`? Its parent?
</details>

<details><summary>Hint 2: the approach</summary>

Children of `i`: `2i + 1` and `2i + 2`. Parent: `(i − 1) / 2`. `add`: put the value at the end and swap it **up** while it is smaller than its parent. `poll`: take index 0, move the last value to index 0, swap it **down**.
</details>

<details><summary>Hint 3: almost the answer</summary>

When sifting down, swap with the **smaller** child, and stop when the value is ≤ both children (or has none). Grow with `Arrays.copyOf(values, size * 2)`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/05-trees-heaps-tries/min-heap.md`.
