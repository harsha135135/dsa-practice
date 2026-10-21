# 7.5 Fewest removals (do this at least a week later)

**Write it in:** `src/main/java/practice/paths/FewestRemovals.java` · **Test:** `./mvnw test -Dtest=FewestRemovalsTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

You get intervals `{start, end}`. Remove as **few** as possible so that no two of the remaining intervals overlap.
Intervals that only touch (one ends exactly where the next starts) do **not** overlap. Return the number removed.

## Examples

| intervals | answer |
|---|---|
| `{1,2} {2,3} {3,4} {1,3}` | `1` (remove {1,3}) |
| `{1,2} {1,2} {1,2}` | `2` |
| `{1,5} {4,7} {6,10}` | `1` (keep {1,5} and {6,10}) |

## Limits

Up to 100,000 intervals. Random small inputs are checked by trying every subset.

## Hints

<details><summary>Hint 1: a nudge</summary>

Removing as few as possible is the same as **keeping** as many as possible.
</details>

<details><summary>Hint 2: the approach</summary>

Try simple rules on paper: keep the shortest first? The earliest start? Find a counter-example for each. One rule has none.
</details>

<details><summary>Hint 3: almost the answer</summary>

Sort by **end**. Walk through; keep an interval if it starts at or after the end of the last kept one. Answer: total minus kept.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/07-paths-union-find-greedy/fewest-removals.md`.
