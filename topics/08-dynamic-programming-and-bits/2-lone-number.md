# 8.2 Lone number (warm-up)

**Write it in:** `src/main/java/practice/dp/LoneNumber.java` · **Test:** `./mvnw test -Dtest=LoneNumberTest`

## Problem

Every number in the array appears **exactly twice**, except one, which appears once. Return that one. Use only
O(1) extra memory (no sets or maps).

## Examples

| numbers | answer |
|---|---|
| `[2, 2, 1]` | `1` |
| `[4, 1, 2, 1, 2]` | `4` |
| `[-7]` | `-7` |

## Limits

Up to 1,000,000 numbers, any `int` values.

## Hints

<details><summary>Hint 1: a nudge</summary>

Is there an operation where combining a number with itself gives nothing?
</details>

<details><summary>Hint 2: the approach</summary>

XOR (`^`): `x ^ x == 0`, `x ^ 0 == x`, and the order does not matter.
</details>

<details><summary>Hint 3: almost the answer</summary>

XOR all numbers together. The pairs cancel; the lone number is what is left.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/08-dynamic-programming-and-bits/lone-number.md`.
