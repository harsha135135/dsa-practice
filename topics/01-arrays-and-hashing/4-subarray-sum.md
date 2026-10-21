# 1.4 Subarray sum (harder)

**Write it in:** `src/main/java/practice/arrays/SubarraySum.java` · **Test:** `./mvnw test -Dtest=SubarraySumTest`

## Problem

Count how many **non-empty runs of neighbouring numbers** (subarrays) add up to exactly `k`.
Numbers can be negative or zero.

## Examples

| numbers | k | answer | why |
|---|---|---|---|
| `[1, 1, 1]` | `2` | `2` | `[1,1]` at positions 0-1 and 1-2 |
| `[1, 2, 3]` | `3` | `2` | `[1,2]` and `[3]` |
| `[0, 0, 0]` | `0` | `6` | every run |

## Limits

Up to 100,000 numbers. Trying every run is O(n²): about 5 billion runs, too slow.

## Hints

<details><summary>Hint 1: a nudge</summary>

Exercise 1.1 turns "sum of a run" into a subtraction of two running totals.
</details>

<details><summary>Hint 2: the approach</summary>

A run ending at `j` sums to `k` when `total(j) - total(i) = k` for some earlier `i`, so
`total(i) = total(j) - k`. How many earlier totals had that value?
</details>

<details><summary>Hint 3: almost the answer</summary>

Keep `Map<Long, Integer> timesSeen`, starting with `{0: 1}` (the total before anything). For each number:
add it to `total`, add `timesSeen[total - k]` to the answer, then increase `timesSeen[total]`.
</details>

## After you solve it

Log it, write your own note, then compare with `solutions/explanations/01-arrays-and-hashing/subarray-sum.md`.
