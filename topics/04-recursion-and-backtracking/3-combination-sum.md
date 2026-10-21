# 4.3 Combination sum (standard)

**Write it in:** `src/main/java/practice/recursion/CombinationSum.java` · **Test:** `./mvnw test -Dtest=CombinationSumTest`

## Problem

Given **distinct positive** `candidates` and a `target`, return every combination of candidates that adds
up to `target`. A candidate may be used **any number of times**. Each combination is sorted (smallest first); the
list is in dictionary order. Target `0` has one answer: pick nothing, `[[]]`.

## Examples

| candidates | target | answer |
|---|---|---|
| `[2, 3, 6, 7]` | `7` | `[[2,2,3], [7]]` |
| `[5, 3, 2]` | `8` | `[[2,2,2,2], [2,3,3], [3,5]]` |
| `[2]` | `1` | `[]` |

## Limits

Targets up to about 100; the coin test has 292 answers.

## Hints

<details><summary>Hint 1: a nudge</summary>

Compared with Subsets: what changes if a value may be picked again?
</details>

<details><summary>Hint 2: the approach</summary>

When you pick `sorted[i]`, the next pick may start at `i` again (not `i + 1`). Keep track of the amount still `remaining`.
</details>

<details><summary>Hint 3: almost the answer</summary>

Stop when `remaining == 0` (record it). Sort the candidates; then, in the loop, `break` as soon as `sorted[i] > remaining`, because every later candidate is bigger too.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/04-recursion-and-backtracking/combination-sum.md`.
