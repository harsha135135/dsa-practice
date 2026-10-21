# 2.4 Ship capacity (harder)

**Write it in:** `src/main/java/practice/searching/ShipCapacity.java` · **Test:** `./mvnw test -Dtest=ShipCapacityTest`

## Problem

Packages with `weights` must be shipped **in the given order** within `days` days. Each day the ship
is loaded with the next packages in line, as long as the total stays within the ship's **capacity**. Return the
**smallest capacity** that ships everything within `days` days.

## Examples

| weights | days | answer | why |
|---|---|---|---|
| `[1..10]` | `5` | `15` | `[1-5] [6,7] [8] [9] [10]` |
| `[3, 2, 2, 4, 1, 4]` | `3` | `6` | `[3,2] [2,4] [1,4]` |
| `[9, 1, 1]` | `10` | `9` | the heaviest package must fit |

## Limits

Up to 50,000 packages, weights up to 1,000,000,000 (use `long` for totals).

## Hints

<details><summary>Hint 1: a nudge</summary>

If capacity c works, does capacity c + 1 work too?
</details>

<details><summary>Hint 2: the approach</summary>

"Does capacity c work?" can be checked in O(n): load each day until the next package does not fit. Then search for the smallest c that works.
</details>

<details><summary>Hint 3: almost the answer</summary>

Binary search c between `max(weights)` (lower bound) and `sum(weights)` (always works). If `daysNeeded(c) <= days`, `high = c`, else `low = c + 1`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/02-sorting-and-searching/ship-capacity.md`.
