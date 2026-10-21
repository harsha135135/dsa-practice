# 3.2 Reverse a linked list (warm-up)

**Write it in:** `src/main/java/practice/lists/ReverseList.java` · **Test:** `./mvnw test -Dtest=ReverseListTest`

## Problem

Reverse a singly linked list in place and return the new head. Reuse the existing nodes; do not
create new ones. An empty list (`null`) stays `null`. `ReverseList.Node` is already written for you.

## Examples

| list | reversed |
|---|---|
| `1 → 2 → 3 → 4 → 5` | `5 → 4 → 3 → 2 → 1` |
| `7` | `7` |
| (empty) | (empty) |

## Limits

Up to 200,000 nodes. A recursive solution may run out of stack; a loop will not.

## Hints

<details><summary>Hint 1: a nudge</summary>

Draw three nodes on paper with arrows. What has to happen to each arrow?
</details>

<details><summary>Hint 2: the approach</summary>

Walk the list once. At each node, turn its `next` arrow to point **backwards**. You need to remember the previous node.
</details>

<details><summary>Hint 3: almost the answer</summary>

Keep `previous` and `current`. Save `next = current.next`, set `current.next = previous`, then move both forward. Return `previous` at the end.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/03-lists-stacks-queues/reverse-list.md`.
