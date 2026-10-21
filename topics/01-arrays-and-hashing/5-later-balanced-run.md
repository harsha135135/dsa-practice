# 1.5 Balanced run (do this at least a week later)

**Write it in:** `src/main/java/practice/arrays/BalancedRun.java` · **Test:** `./mvnw test -Dtest=BalancedRunTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

You get an array of bits (each `0` or `1`). Find the length of the longest run of neighbouring
bits that contains **as many 0s as 1s**. If there is none, the answer is `0`.

## Examples

| bits | answer |
|---|---|
| `[0, 1]` | `2` |
| `[0, 1, 1, 0, 1, 0, 0]` | `6` |
| `[1, 1, 1]` | `0` |

## Limits

Up to 100,000 bits.

## Hints

<details><summary>Hint 1: a nudge</summary>

Can you change the question into one about sums?
</details>

<details><summary>Hint 2: the approach</summary>

Count a 1 as `+1` and a 0 as `-1`. A balanced run has total `0`. When do two running totals tell you that?
</details>

<details><summary>Hint 3: almost the answer</summary>

Remember the **first** index where each running total appeared (start with total `0` at index `-1`).
When a total appears again at `i`, the run in between is balanced: length `i - first`.
</details>

## After you solve it

Log it, write your own note, then compare with `solutions/explanations/01-arrays-and-hashing/balanced-run.md`.
