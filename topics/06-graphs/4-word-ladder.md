# 6.4 Word ladder (harder)

**Write it in:** `src/main/java/practice/graphs/WordLadder.java` · **Test:** `./mvnw test -Dtest=WordLadderTest`

## Problem

Change `begin` into `end` one letter at a time. Every word in between, and `end` itself, must be in `words`.
Return the number of words in the **shortest** chain (counting `begin` and `end`), or `0` if no chain exists.
All words have the same length and use lowercase letters.

## Examples

| begin | end | words | answer |
|---|---|---|---|
| `hit` | `cog` | `hot dot dog lot log cog` | `5` (hit → hot → dot → dog → cog) |
| `hit` | `cog` | `hot dot dog lot log` | `0` (cog is missing) |
| `cat` | `cat` | `cat` | `1` |

## Limits

Up to 5,000 words of up to 10 letters.

## Hints

<details><summary>Hint 1: a nudge</summary>

Think of each word as a node. Which words are its neighbours?
</details>

<details><summary>Hint 2: the approach</summary>

"Shortest chain" with every step counting 1 means breadth-first search. You do not need to build the whole graph first.
</details>

<details><summary>Hint 3: almost the answer</summary>

To find a word's neighbours, change each position to every letter `a` to `z` and check a `HashSet` of unused words. Remove a word from the set when you first reach it. Count rings (process the queue one ring at a time).
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/06-graphs/word-ladder.md`.
