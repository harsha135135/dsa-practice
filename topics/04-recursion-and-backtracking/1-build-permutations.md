# 4.1 Build permutations (build it)

**Write it in:** `src/main/java/practice/recursion/Permutations.java` · **Test:** `./mvnw test -Dtest=PermutationsTest`

## Problem

Return every ordering (permutation) of the given **distinct** values, in dictionary order. The input can
be in any order. For no values, return one empty ordering: `[[]]`.

## Examples

| values | answer |
|---|---|
| `[3, 1, 2]` | `[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]` |
| `[5]` | `[[5]]` |
| `[]` | `[[]]` |

## Limits

Up to 8 values (40,320 orderings).

## Hints

<details><summary>Hint 1: a nudge</summary>

How would you fill position 0? Then position 1, given what is left?
</details>

<details><summary>Hint 2: the approach</summary>

Recursive helper: `build(current ordering, which values are used)`. If the ordering is full, record a copy. Otherwise try each unused value in the next position.
</details>

<details><summary>Hint 3: almost the answer</summary>

Sort the values first so the results come out in dictionary order. After the recursive call, **undo**: remove the last value and mark it unused.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/04-recursion-and-backtracking/permutations.md`.
