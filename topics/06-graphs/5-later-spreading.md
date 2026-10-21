# 6.5 Spreading (do this at least a week later)

**Write it in:** `src/main/java/practice/graphs/Spreading.java` · **Test:** `./mvnw test -Dtest=SpreadingTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

A grid has empty cells `0`, healthy cells `1` and sick cells `2`. Every minute, each healthy cell next to a sick
cell (up, down, left or right) becomes sick. Return the number of minutes until **no healthy cell is left**, or `-1` if
some healthy cell can never be reached. Do not change the caller's grid.

## Examples

| grid | answer |
|---|---|
| `2 1 1 / 1 1 0 / 0 1 1` | `4` |
| `2 1 1 / 0 1 1 / 1 0 1` | `-1` (the bottom-left cell is cut off) |
| `0 2` | `0` (nothing healthy) |

## Limits

Random grids are checked against a minute-by-minute simulation.

## Hints

<details><summary>Hint 1: a nudge</summary>

Simulating the whole grid every minute works, but repeats a lot of work. Which cells actually change each minute?
</details>

<details><summary>Hint 2: the approach</summary>

Only neighbours of cells that became sick in the **previous** minute. That sounds like rings of a breadth-first search, but starting from several places.
</details>

<details><summary>Hint 3: almost the answer</summary>

Put **every** sick cell in the queue at the start. Process one ring per minute. Count the healthy cells, and lower the count each time one turns sick. Answer the minutes if the count reaches 0, else `-1`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/06-graphs/spreading.md`.
