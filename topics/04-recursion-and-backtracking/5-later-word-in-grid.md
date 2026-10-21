# 4.5 Word in a grid (do this at least a week later)

**Write it in:** `src/main/java/practice/recursion/WordInGrid.java` · **Test:** `./mvnw test -Dtest=WordInGridTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

Given a grid of letters and a `word`, return `true` if the word can be spelled by starting at any cell and
moving **up, down, left or right** to the next letter each time. A cell may be used **at most once** in one spelling.
The empty word is always found.

## Examples

Grid:
```
A B C E
S F C S
A D E E
```
| word | answer |
|---|---|
| `ABCCED` | `true` |
| `SEE` | `true` |
| `ABCB` | `false` (would reuse the B) |
| `AF` | `false` (diagonal steps are not allowed) |

## Limits

Grids up to 6 × 6, words up to 15 letters.

## Hints

<details><summary>Hint 1: a nudge</summary>

Try every cell as the start. From there, the question is: can the **rest** of the word be spelled from a neighbour?
</details>

<details><summary>Hint 2: the approach</summary>

A recursive `matchFrom(index, row, col)`: fail if off the grid, already in use, or the wrong letter; succeed if it is the last letter; otherwise try the four neighbours with `index + 1`.
</details>

<details><summary>Hint 3: almost the answer</summary>

Mark the cell as in use before trying neighbours and **unmark it afterwards**, whether or not it worked, so other paths can use it.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/04-recursion-and-backtracking/word-in-grid.md`.
