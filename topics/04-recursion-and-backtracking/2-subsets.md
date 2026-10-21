# 4.2 Subsets (warm-up)

**Write it in:** `src/main/java/practice/recursion/Subsets.java` · **Test:** `./mvnw test -Dtest=SubsetsTest`

## Problem

Return every subset of the given **distinct** values (including the empty set and the whole set).
Each subset is sorted, and the list of subsets is in dictionary order: compare element by element, and a subset
that is a prefix of another comes first.

## Examples

| values | answer |
|---|---|
| `[3, 1, 2]` | `[[], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]]` |
| `[]` | `[[]]` |

## Limits

Up to 15 values (32,768 subsets).

## Hints

<details><summary>Hint 1: a nudge</summary>

Each value is either in the subset or not, so there are 2ⁿ subsets.
</details>

<details><summary>Hint 2: the approach</summary>

Every partial choice is already a subset. Record it, then try adding each value that comes **after** the last value you added.
</details>

<details><summary>Hint 3: almost the answer</summary>

`build(start, current)`: record a copy of `current`; for `i` from `start`: add `sorted[i]`, `build(i + 1)`, remove it.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/04-recursion-and-backtracking/subsets.md`.
