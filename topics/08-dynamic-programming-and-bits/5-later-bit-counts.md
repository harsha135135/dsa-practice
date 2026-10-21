# 8.5 Bit counts (do this at least a week later)

**Write it in:** `src/main/java/practice/dp/BitCounts.java` · **Test:** `./mvnw test -Dtest=BitCountsTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

For every number from `0` to `n`, count how many of its binary digits (bits) are `1`. Return the counts as an
array of length `n + 1`. Do not call `Integer.bitCount`; aim for O(n) total.

## Examples

| n | answer | binary |
|---|---|---|
| `2` | `[0, 1, 1]` | 0, 1, 10 |
| `5` | `[0, 1, 1, 2, 1, 2]` | 0, 1, 10, 11, 100, 101 |

## Limits

`n` up to 1,000,000; checked against `Integer.bitCount`.

## Hints

<details><summary>Hint 1: a nudge</summary>

Counting the bits of each number separately is O(n log n). Can a number's count come from a **smaller** number's count?
</details>

<details><summary>Hint 2: the approach</summary>

Look at `i` and `i >> 1` (i with its last bit dropped). How do their counts differ?
</details>

<details><summary>Hint 3: almost the answer</summary>

`ones[i] = ones[i >> 1] + (i & 1)`, filling `i` upwards from 1.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/08-dynamic-programming-and-bits/bit-counts.md`.
