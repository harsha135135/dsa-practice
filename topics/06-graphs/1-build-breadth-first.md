# 6.1 Build breadth-first search (build it)

**Write it in:** `src/main/java/practice/graphs/BreadthFirst.java` · **Test:** `./mvnw test -Dtest=BreadthFirstTest`

## Problem

A graph has nodes `0` to `n − 1` and **undirected** edges (`{a, b}` joins `a` and `b` both ways). Return an
array with the fewest edges from `source` to each node, or `-1` for nodes that cannot be reached.

## Examples

Edges `{0,1} {1,2} {0,5} {5,2} {3,4}`, n = 6:

| source | answer |
|---|---|
| `0` | `[0, 1, 2, -1, -1, 1]` |
| `4` | `[-1, -1, -1, 1, 0, -1]` |

## Limits

Random graphs are checked against a slow all-pairs method.

## Hints

<details><summary>Hint 1: a nudge</summary>

First turn the edge list into an adjacency list: for each node, a `List<Integer>` of neighbours.
</details>

<details><summary>Hint 2: the approach</summary>

Use a queue. Start with `source` at distance 0. Take a node from the front and give each **not yet reached** neighbour distance + 1, then add it to the back.
</details>

<details><summary>Hint 3: almost the answer</summary>

Fill `distance` with `-1` (which also means "not reached"). Set it **when you add a node to the queue**, not when you remove it, so no node is added twice.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/06-graphs/breadth-first.md`.
