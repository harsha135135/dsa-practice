# 2.5 Shortest window with every kind (do this at least a week later)

**Write it in:** `src/main/java/practice/searching/ShortestWindow.java` · **Test:** `./mvnw test -Dtest=ShortestWindowTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

Return the length of the **shortest run of neighbouring values** that contains **every different value**
that appears anywhere in the array. For an empty array, return `0`.

## Examples

| values | answer | why |
|---|---|---|
| `[1, 2, 2, 3, 1]` | `3` | `[2, 3, 1]` |
| `[7, 7, 7]` | `1` | `[7]` |
| `[1, 2, 3, 4]` | `4` | the whole array |

## Limits

Up to 100,000 values. Trying every run is O(n²).

## Hints

<details><summary>Hint 1: a nudge</summary>

If a run contains every kind, so does any longer run that includes it. If it does not, neither does any shorter run inside it.
</details>

<details><summary>Hint 2: the approach</summary>

Keep a window `[left, right]` and a count of each value inside it. Move `right` forward; whenever the window has every kind, try shrinking from the left.
</details>

<details><summary>Hint 3: almost the answer</summary>

`Map<Integer, Integer> countInWindow`. After adding `values[right]`: while `countInWindow.size() == kinds`, record the length, remove `values[left]` (delete the key at count 0), `left++`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/02-sorting-and-searching/shortest-window.md`.
