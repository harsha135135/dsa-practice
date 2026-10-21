# 7.2 Extra connection (warm-up)

**Write it in:** `src/main/java/practice/paths/ExtraConnection.java` · **Test:** `./mvnw test -Dtest=ExtraConnectionTest`

## Problem

A network of nodes `1` to `n` was a **tree** (connected, no cycles), and then **one extra edge** was added, so
there are now `n` edges. Return an edge whose removal makes it a tree again. If several edges work, return the one that
appears **last** in the input.

## Examples

| edges | answer |
|---|---|
| `{1,2} {1,3} {2,3}` | `{2,3}` |
| `{1,2} {2,3} {3,4} {1,4} {1,5}` | `{1,4}` |

## Limits

Random trees with one extra edge are checked by brute force.

## Hints

<details><summary>Hint 1: a nudge</summary>

The extra edge created exactly one cycle. Removing any edge on that cycle gives a tree again.
</details>

<details><summary>Hint 2: the approach</summary>

Add the edges one at a time and keep track of which nodes are connected. What is special about the edge that closes the cycle?
</details>

<details><summary>Hint 3: almost the answer</summary>

Use your union-find: the first edge whose two ends are **already connected** is the answer (it is also the last cycle edge in the input).
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/07-paths-union-find-greedy/extra-connection.md`.
