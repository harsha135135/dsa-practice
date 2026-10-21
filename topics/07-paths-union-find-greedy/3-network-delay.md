# 7.3 Network delay (standard)

**Write it in:** `src/main/java/practice/paths/NetworkDelay.java` · **Test:** `./mvnw test -Dtest=NetworkDelayTest`

## Problem

Nodes `0` to `n − 1` pass a signal along **one-way** links `{from, to, minutes}`. A signal starts at `source` at
time 0. Return how many minutes until **every** node has received it, or `-1` if some node never does.

## Examples

| n | links | source | answer |
|---|---|---|---|
| 4 | `{1,0,1} {1,2,1} {2,3,1}` | 1 | `2` |
| 3 | `{0,2,10} {0,1,2} {1,2,3}` | 0 | `5` (through node 1 is faster) |
| 2 | `{0,1,1}` | 1 | `-1` (links are one-way) |

## Limits

Random networks are checked against Bellman-Ford. Minutes are never negative.

## Hints

<details><summary>Hint 1: a nudge</summary>

Each node hears the signal at the length of its **shortest** path from the source. The answer is the biggest of those.
</details>

<details><summary>Hint 2: the approach</summary>

BFS counts edges, but here edges have different lengths. Which node's time can you be **sure** is final?
</details>

<details><summary>Hint 3: almost the answer</summary>

Dijkstra: a priority queue of (node, time), smallest time first. Poll; skip it if a better time is already known; otherwise try every outgoing link and push any improvement.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/07-paths-union-find-greedy/network-delay.md`.
