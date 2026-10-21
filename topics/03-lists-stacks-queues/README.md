# Topic 3: linked lists, stacks, queues

## Ideas to know

- **Linked list:** each item holds a pointer to the next. Adding or removing at a node you already hold is O(1); finding the i-th item is O(n).
- **Stack (last in, first out):** like a pile of plates. In Java: `ArrayDeque` with `push` / `pop` / `peek`.
- **Queue (first in, first out):** like a line at a shop. In Java: `ArrayDeque` with `addLast` / `removeFirst`.
- **Monotonic stack:** a stack kept in increasing or decreasing order. It answers "what is the next bigger value?" for every item in one pass.
- **HashMap + linked list:** fast lookup plus fast reordering. This is how caches work.

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build a linked queue](1-build-linked-queue.md) | build it | `LinkedQueue` |
| 2 | [Reverse a linked list](2-reverse-list.md) | warm-up | `ReverseList` |
| 3 | [Balanced brackets](3-balanced-brackets.md) | standard | `BalancedBrackets` |
| 4 | [LRU cache](4-lru-cache.md) | harder | `LruCache` |
| 5 | [Next warmer day](5-later-warmer-day.md) | do it **at least a week later** | `WarmerDay` |

Your code goes in `src/main/java/practice/lists/`. Run one exercise's tests with
`./mvnw test -Dtest=<Class>Test`.
