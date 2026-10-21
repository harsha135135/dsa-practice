# 8.3 Longest common subsequence (standard)

**Write it in:** `src/main/java/practice/dp/CommonSubsequence.java` · **Test:** `./mvnw test -Dtest=CommonSubsequenceTest`

## Problem

A **subsequence** keeps some letters of a string, in order, possibly with gaps (`ace` is a subsequence of `abcde`).
Return the length of the longest subsequence that appears in **both** strings.

## Examples

| a | b | answer |
|---|---|---|
| `abcde` | `ace` | `3` |
| `abc` | `def` | `0` |
| `abc` | `abc` | `3` |

## Limits

Strings up to 3,000 letters. Plain recursion is exponential; it is fine only up to about 10 letters.

## Hints

<details><summary>Hint 1: a nudge</summary>

Compare the **last** letters of the two strings. What happens if they match? If they do not?
</details>

<details><summary>Hint 2: the approach</summary>

Let `length[i][j]` = the answer for the first `i` letters of `a` and the first `j` letters of `b`. An empty prefix gives 0.
</details>

<details><summary>Hint 3: almost the answer</summary>

If `a[i−1] == b[j−1]`: `length[i][j] = length[i−1][j−1] + 1`. Otherwise: `max(length[i−1][j], length[i][j−1])`. Fill row by row; the answer is `length[a.length][b.length]`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/08-dynamic-programming-and-bits/common-subsequence.md`.
