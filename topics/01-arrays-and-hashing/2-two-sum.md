# 1.2 Two sum (warm-up)

**Write it in:** `src/main/java/practice/arrays/TwoSum.java` · **Test:** `./mvnw test -Dtest=TwoSumTest`

## Problem

Given an array `numbers` and a `target`, return two **different** positions `{i, j}` with
`i < j` and `numbers[i] + numbers[j] == target`. If several pairs work, any one is fine. If none
works, return an empty array.

## Examples

| numbers | target | a correct answer |
|---|---|---|
| `[2, 7, 11, 15]` | `9` | `{0, 1}` |
| `[3, 3]` | `6` | `{0, 1}` |
| `[5]` | `10` | `{}` (5 cannot pair with itself) |

## Limits

Up to 100,000 numbers. Checking every pair (about 5 billion pairs) is too slow.

## Hints

<details><summary>Hint 1: a nudge</summary>

While walking through the array, at position `j` you know which value you need: `target - numbers[j]`.
</details>

<details><summary>Hint 2: the approach</summary>

Remember every value you have passed, and where. Then "have I seen the value I need?" is one lookup.
</details>

<details><summary>Hint 3: almost the answer</summary>

`Map<Integer, Integer> indexByValue`. For each `j`: look up `target - numbers[j]`; if found, return
`{found, j}`; otherwise store `numbers[j] -> j`. Look up **before** storing, so a number never pairs with itself.
</details>

## After you solve it

Log it, write your own note, then compare with `solutions/explanations/01-arrays-and-hashing/two-sum.md`.
