# 7.1 Build union-find (build it)

**Write it in:** `src/main/java/practice/paths/UnionFind.java` · **Test:** `./mvnw test -Dtest=UnionFindTest`

## Problem

Build a structure that keeps items `0` to `n − 1` in groups. At the start, each item is alone.
- `find(x)`: a representative of `x`'s group (two items are together exactly when `find` gives the same answer).
- `union(a, b)`: join the two groups; return `false` if they were already the same group.
- `connected(a, b)`, and `groups()`: how many groups there are.

The test joins a chain of 1,000,000 items, so `find` must stay fast.

## Examples

`n = 5`: `union(0,1)`, `union(3,4)`, `union(1,4)` all return `true`; `union(0,3)` returns `false`. Now `groups()` is `2`
(`{0,1,3,4}` and `{2}`).

## Limits

2,000 random steps are compared with a simple label array; one test uses a chain of a million items.

## Hints

<details><summary>Hint 1: a nudge</summary>

Store each group as a tree: `parent[x]` points towards the group's root. The root is the representative.
</details>

<details><summary>Hint 2: the approach</summary>

`find` follows parents up to the root. `union` hangs one root under the other. Without care, trees become long chains and `find` becomes O(n).
</details>

<details><summary>Hint 3: almost the answer</summary>

Two fixes: **union by size** (hang the smaller tree under the bigger) and **path compression** (after finding the root, point every node on the path straight at it). Keep `groups` as a counter.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/07-paths-union-find-greedy/union-find.md`.
