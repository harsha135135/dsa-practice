# 3.1 Build a linked queue (build it)

**Write it in:** `src/main/java/practice/lists/LinkedQueue.java` · **Test:** `./mvnw test -Dtest=LinkedQueueTest`

## Problem

Write a generic first-in, first-out queue `LinkedQueue<T>` using your own linked nodes (no `java.util`
collections):
- `add(item)`: add at the back.
- `remove()`: remove and return the front item; throw `NoSuchElementException` when empty.
- `peek()`: return the front item without removing it, or `null` when empty.
- `size()`, `isEmpty()`.

Every operation must take O(1) time.

## Examples

| steps | result |
|---|---|
| add a, add b, add c, remove, remove | `a`, then `b` |
| peek on an empty queue | `null` |
| remove on an empty queue | `NoSuchElementException` |

## Limits

10,000 random steps are compared with Java's own queue.

## Hints

<details><summary>Hint 1: a nudge</summary>

A node holds an item and a pointer to the next node. Which end do you add to, and which do you remove from?
</details>

<details><summary>Hint 2: the approach</summary>

Keep two pointers: `head` (front, removed next) and `tail` (back, newest). Add at the tail, remove at the head.
</details>

<details><summary>Hint 3: almost the answer</summary>

When the queue becomes empty after `remove`, set **both** `head` and `tail` to `null`, or the next `add` links onto a dead node.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/03-lists-stacks-queues/linked-queue.md`.
