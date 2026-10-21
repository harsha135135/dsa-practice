# 4.4 N queens (harder)

**Write it in:** `src/main/java/practice/recursion/Queens.java` · **Test:** `./mvnw test -Dtest=QueensTest`

## Problem

Count the ways to place `n` queens on an `n × n` chessboard so that no two attack each other. A queen
attacks along its row, its column and both diagonals.

## Examples

| n | answer |
|---|---|
| 1 | 1 |
| 2, 3 | 0 |
| 4 | 2 |
| 8 | 92 |

## Limits

`n = 12` (14,200 solutions) should finish in well under a second.

## Hints

<details><summary>Hint 1: a nudge</summary>

Every row must contain exactly one queen.
</details>

<details><summary>Hint 2: the approach</summary>

Place queens row by row. For each column in the current row, check whether that column or either diagonal is already taken.
</details>

<details><summary>Hint 3: almost the answer</summary>

Cells on one `\` diagonal share `row − col`; on one `/` diagonal they share `row + col`. Keep three boolean arrays (columns, `row − col + n`, `row + col`) so each check is O(1).
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/04-recursion-and-backtracking/queens.md`.
