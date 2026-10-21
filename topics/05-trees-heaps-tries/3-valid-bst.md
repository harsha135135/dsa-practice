# 5.3 Valid binary search tree (standard)

**Write it in:** `src/main/java/practice/trees/ValidBst.java` · **Test:** `./mvnw test -Dtest=ValidBstTest`

## Problem

Return `true` if the tree is a valid **binary search tree**: for every node, **every** value in its left
subtree is strictly smaller, and **every** value in its right subtree is strictly bigger. Equal values are not allowed.
An empty tree is valid.

## Examples

| tree | answer |
|---|---|
| `2` with children `1`, `3` | `true` |
| `5` with left `1` and right `6`, where `6` has children `3` and `7` | `false`: 3 is in 5's right subtree but smaller than 5 |
| `2` with left child `2` | `false` |

## Limits

Values can be `Integer.MIN_VALUE` and `Integer.MAX_VALUE`.

## Hints

<details><summary>Hint 1: a nudge</summary>

Comparing each node only with its own children is **not** enough. Look at the second example.
</details>

<details><summary>Hint 2: the approach</summary>

Each node must lie in a range `(low, high)` decided by its ancestors. Going left lowers `high`; going right raises `low`.
</details>

<details><summary>Hint 3: almost the answer</summary>

`isWithin(node, low, high)`: true for `null`; false if `value <= low` or `value >= high`; otherwise check `left` with `(low, value)` and `right` with `(value, high)`. Use `long` bounds so the extreme `int`s work.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/05-trees-heaps-tries/valid-bst.md`.
