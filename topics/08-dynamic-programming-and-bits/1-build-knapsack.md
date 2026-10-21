# 8.1 Build 0/1 knapsack (build it)

**Write it in:** `src/main/java/practice/dp/Knapsack.java` · **Test:** `./mvnw test -Dtest=KnapsackTest`

## Problem

Items have `weights` and `values`. Choose items whose total weight is at most `capacity`, using each item **at
most once**, to get the **largest total value**. Return that value.

## Examples

| weights | values | capacity | answer |
|---|---|---|---|
| `1 3 4 5` | `1 4 5 7` | `7` | `9` (weights 3 + 4) |
| `1 2 3` | `6 10 12` | `5` | `22` (best value per weight first gives only 16) |
| `2` | `10` | `10` | `10` (only once) |

## Limits

Up to 100 items and capacity up to 10,000. Trying every subset (2¹⁰⁰) is impossible.

## Hints

<details><summary>Hint 1: a nudge</summary>

For the last item there are two choices: leave it out, or take it (if it fits). Each choice leaves a smaller problem.
</details>

<details><summary>Hint 2: the approach</summary>

Let `best[c]` = the most value with capacity `c`, using the items handled so far. How does adding one more item change `best[c]`?
</details>

<details><summary>Hint 3: almost the answer</summary>

For each item, for `c` from `capacity` **down to** `weight`: `best[c] = max(best[c], value + best[c − weight])`. Going downwards makes sure `best[c − weight]` does not already include this item.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/08-dynamic-programming-and-bits/knapsack.md`.
