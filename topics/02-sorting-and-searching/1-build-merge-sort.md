# 2.1 Build merge sort (build it)

**Write it in:** `src/main/java/practice/searching/MergeSort.java` · **Test:** `./mvnw test -Dtest=MergeSortTest`

## Problem

Write `MergeSort.sort(int[] values)`, which sorts the array in place from smallest to largest
using **merge sort**: split the array in half, sort each half the same way, then merge the two sorted halves.
Do not call `Arrays.sort`.

## Examples

| before | after |
|---|---|
| `[5, 2, 4, 6, 1, 3]` | `[1, 2, 3, 4, 5, 6]` |
| `[]` | `[]` |
| `[2, 2, 1, 1]` | `[1, 1, 2, 2]` |

## Limits

Up to 200,000 values. Insertion sort (O(n²)) is too slow for the big test.

## Hints

<details><summary>Hint 1: a nudge</summary>

An array of 0 or 1 values is already sorted. That is where the splitting stops.
</details>

<details><summary>Hint 2: the approach</summary>

Merging two sorted halves: look at the front of each, take the smaller one, repeat. Use a second array (a buffer) to merge into.
</details>

<details><summary>Hint 3: almost the answer</summary>

`sort(values, buffer, from, to)`: if `to - from < 2` return; `middle = (from + to) >>> 1`; sort both halves; merge `[from, middle)` and `[middle, to)` into `buffer`; copy back.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/02-sorting-and-searching/merge-sort.md`.
