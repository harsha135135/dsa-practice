# 2.3 Three sum (standard)

**Write it in:** `src/main/java/practice/searching/ThreeSum.java` · **Test:** `./mvnw test -Dtest=ThreeSumTest`

## Problem

Find every **different** triple of values `[a, b, c]` from the array (three different positions) with
`a + b + c == 0`. Write each triple smallest first (`a <= b <= c`), list each triple once, and sort the list
(by `a`, then `b`, then `c`). Do not change the input array.

## Examples

| numbers | answer |
|---|---|
| `[-1, 0, 1, 2, -1, -4]` | `[[-1, -1, 2], [-1, 0, 1]]` |
| `[0, 1, 1]` | `[]` |
| `[0, 0, 0, 0]` | `[[0, 0, 0]]` |

## Limits

Up to 3,000 numbers. Trying every triple is O(n³), about 4.5 billion steps.

## Hints

<details><summary>Hint 1: a nudge</summary>

Sorting first makes both the search and the "no repeats" rule easier.
</details>

<details><summary>Hint 2: the approach</summary>

Fix the smallest value `a = sorted[i]`. Now you need two values to the right adding up to `-a`: a pair problem in a sorted range.
</details>

<details><summary>Hint 3: almost the answer</summary>

For the pair: `left = i + 1`, `right = n - 1`. Sum too small? `left++`. Too big? `right--`. Equal? Record it, then skip repeated values. Also skip `i` when `sorted[i] == sorted[i-1]`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/02-sorting-and-searching/three-sum.md`.
