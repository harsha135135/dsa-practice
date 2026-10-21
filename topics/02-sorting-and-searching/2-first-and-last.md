# 2.2 First and last position (warm-up)

**Write it in:** `src/main/java/practice/searching/FirstAndLast.java` · **Test:** `./mvnw test -Dtest=FirstAndLastTest`

## Problem

Given an array sorted from smallest to largest and a `target`, return `{first, last}`: the first and last
index where `target` appears. If it does not appear, return `{-1, -1}`.

## Examples

| sorted | target | answer |
|---|---|---|
| `[5, 7, 7, 8, 8, 10]` | `8` | `{3, 4}` |
| `[5, 7, 7, 8, 8, 10]` | `6` | `{-1, -1}` |
| `[4, 4, 4]` | `4` | `{0, 2}` |

## Limits

Up to 1,000,000 values. Aim for O(log n): scanning is O(n).

## Hints

<details><summary>Hint 1: a nudge</summary>

Binary search usually finds *a* matching index. Here you need the *edges*.
</details>

<details><summary>Hint 2: the approach</summary>

Write one helper: "the first index whose value is ≥ x". Call it twice.
</details>

<details><summary>Hint 3: almost the answer</summary>

first = firstAtLeast(target). If it is past the end or the value there is not `target`, answer `{-1,-1}`. last = firstAtLeast(target + 1) − 1. Use `long` for `target + 1`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/02-sorting-and-searching/first-and-last.md`.
