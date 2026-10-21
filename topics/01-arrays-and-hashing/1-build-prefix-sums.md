# 1.1 Build prefix sums (build it)

**Write it in:** `src/main/java/practice/arrays/PrefixSums.java` · **Test:** `./mvnw test -Dtest=PrefixSumsTest`

## Problem

Build a class that takes an array of integers once, and can then answer many questions
"what is the sum from index `from` to index `to`, both included?". Each question should take
the same short time, however long the stretch.

- `new PrefixSums(int[] values)` does the preparation.
- `sum(from, to)` returns the sum as a `long`.
- If not `0 <= from <= to < values.length`, throw `IllegalArgumentException`.

## Examples

| values | call | answer |
|---|---|---|
| `[3, -1, 4, 1, 5]` | `sum(0, 2)` | `6` |
| `[3, -1, 4, 1, 5]` | `sum(1, 4)` | `9` |
| `[MAX_INT, MAX_INT]` | `sum(0, 1)` | `4294967294` (does not overflow) |

## Limits

Up to 100,000 values and 100,000 questions. Adding up the stretch for each question is too slow.

## Hints

<details><summary>Hint 1: a nudge</summary>

What if you stored, for every position, the total of everything **before** it?
</details>

<details><summary>Hint 2: the approach</summary>

Let `prefix[i]` be the sum of the first `i` values (so `prefix[0] = 0`). How do you get the sum
from `from` to `to` using two entries of `prefix`?
</details>

<details><summary>Hint 3: almost the answer</summary>

`sum(from, to) = prefix[to + 1] - prefix[from]`. Make `prefix` a `long[]` of length `n + 1`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/01-arrays-and-hashing/prefix-sums.md`.
