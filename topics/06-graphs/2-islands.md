# 6.2 Count islands (warm-up)

**Write it in:** `src/main/java/practice/graphs/Islands.java` · **Test:** `./mvnw test -Dtest=IslandsTest`

## Problem

A grid has land `'1'` and water `'0'`. An **island** is a group of land cells joined **up, down, left or right**
(not diagonally). Count the islands.

## Examples

```
11000
11000
00100
00011
```
Answer: `3`. A grid of `10` / `01` has `2` islands (diagonals do not join).

## Limits

Up to 1000 × 1000 cells. One island can have a million cells, so recursion may overflow the call stack: use your own stack or queue.

## Hints

<details><summary>Hint 1: a nudge</summary>

Scan every cell. When you find land you have not seen yet, that is a new island.
</details>

<details><summary>Hint 2: the approach</summary>

When you find a new island, mark **all** of its cells as seen right away, so you do not count it again.
</details>

<details><summary>Hint 3: almost the answer</summary>

Mark with a flood fill: push the start cell on an `ArrayDeque`; pop a cell, push each neighbouring land cell not yet seen (marking it seen as you push).
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/06-graphs/islands.md`.
