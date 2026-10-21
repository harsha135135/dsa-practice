# 3.4 LRU cache (harder)

**Write it in:** `src/main/java/practice/lists/LruCache.java` · **Test:** `./mvnw test -Dtest=LruCacheTest`

## Problem

Build a cache with a fixed **capacity** that drops the **least recently used** key when it gets too full.
- `get(key)`: return the value or `null`. Getting a key counts as using it.
- `put(key, value)`: store or replace. Replacing counts as using it. If there are now more than `capacity` keys,
  drop the least recently used one.

Both operations must be O(1) on average. Do not use `LinkedHashMap` (the test uses it to check your answers).

## Examples

Capacity 2: `put(1,1)`, `put(2,2)`, `get(1)` gives `1`, `put(3,3)` drops key 2, `get(2)` gives `null`,
`put(4,4)` drops key 1, `get(3)` gives `3`.

## Limits

Thousands of random steps are compared with a reference cache.

## Hints

<details><summary>Hint 1: a nudge</summary>

You need two things fast: find a key, and know which key was used least recently.
</details>

<details><summary>Hint 2: the approach</summary>

A `HashMap` finds a key. A **doubly linked list** keeps keys in order of use, and can move any node you already hold to the front in O(1).
</details>

<details><summary>Hint 3: almost the answer</summary>

Map key → node. On every use, unlink the node and link it at the front. To drop, remove the node at the back (and its map entry). Two placeholder nodes at the ends save you from null checks.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/03-lists-stacks-queues/lru-cache.md`.
