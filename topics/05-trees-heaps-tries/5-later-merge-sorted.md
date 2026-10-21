# 5.5 Merge sorted arrays (do this at least a week later)

**Write it in:** `src/main/java/practice/trees/MergeSorted.java` · **Test:** `./mvnw test -Dtest=MergeSortedTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

You get `k` arrays, each sorted from smallest to largest. Merge them into one sorted array.

## Examples

| arrays | answer |
|---|---|
| `[1,4,5] [1,3,4] [2,6]` | `[1,1,2,3,4,4,5,6]` |
| (none) | `[]` |
| `[] [7] []` | `[7]` |

## Limits

Up to 2,000 arrays and 200,000 values in total. Aim for better than joining and sorting everything.

## Hints

<details><summary>Hint 1: a nudge</summary>

Merging **two** sorted arrays is easy: repeatedly take the smaller front. What changes with k fronts?
</details>

<details><summary>Hint 2: the approach</summary>

At every step you need the smallest of k front values, and then one front changes. Which structure keeps the smallest on top while values change?
</details>

<details><summary>Hint 3: almost the answer</summary>

A heap of (value, which array, position). Put each array's first value in. Repeatedly poll the smallest, write it out, and push the next value from the same array if there is one.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/05-trees-heaps-tries/merge-sorted.md`.
