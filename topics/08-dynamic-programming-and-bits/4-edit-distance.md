# 8.4 Edit distance (harder)

**Write it in:** `src/main/java/practice/dp/EditDistance.java` · **Test:** `./mvnw test -Dtest=EditDistanceTest`

## Problem

Return the fewest single-letter **inserts**, **deletes** or **replacements** needed to turn string `a` into string `b`.

## Examples

| a | b | answer |
|---|---|---|
| `horse` | `ros` | `3` (replace h→r, delete r, delete e) |
| `intention` | `execution` | `5` |
| `` (empty) | `abc` | `3` |

## Limits

Strings up to 2,000 letters. Small random cases are checked against plain recursion.

## Hints

<details><summary>Hint 1: a nudge</summary>

Compared with exercise 8.3, the table is almost the same. What does the first row and the first column mean now?
</details>

<details><summary>Hint 2: the approach</summary>

`cost[i][j]` = edits to turn the first `i` letters of `a` into the first `j` letters of `b`. `cost[i][0] = i` (delete all), `cost[0][j] = j` (insert all).
</details>

<details><summary>Hint 3: almost the answer</summary>

If the last letters match: `cost[i−1][j−1]`. Otherwise `1 + min(cost[i−1][j−1] (replace), cost[i−1][j] (delete), cost[i][j−1] (insert))`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/08-dynamic-programming-and-bits/edit-distance.md`.
