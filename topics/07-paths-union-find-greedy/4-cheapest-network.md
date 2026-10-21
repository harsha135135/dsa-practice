# 7.4 Cheapest network (harder)

**Write it in:** `src/main/java/practice/paths/CheapestNetwork.java` · **Test:** `./mvnw test -Dtest=CheapestNetworkTest`

## Problem

You must connect nodes `0` to `n − 1` so that every node can reach every other (directly or through others).
You are offered links `{a, b, cost}`. Return the **lowest total cost**, or `-1` if the offered links cannot connect everything.

## Examples

| n | links | answer |
|---|---|---|
| 3 | `{0,1,5} {0,2,6} {1,2,1}` | `6` (links 1-2 and 0-1) |
| 4 | `{0,1,3} {2,3,4}` | `-1` |
| 1 | (none) | `0` |

## Limits

Random small inputs are checked by trying every subset of links. Costs are not negative.

## Hints

<details><summary>Hint 1: a nudge</summary>

The cheapest connected network never contains a cycle. Why? What could you remove?
</details>

<details><summary>Hint 2: the approach</summary>

Consider the links from cheapest to most expensive. When is it safe to take a link, and when is it useless?
</details>

<details><summary>Hint 3: almost the answer</summary>

Kruskal: sort links by cost; take a link only if `union(a, b)` returns `true` (it joins two separate groups). At the end, check there is exactly one group.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/07-paths-union-find-greedy/cheapest-network.md`.
