# 3.2 Reverse a linked list: explanation

**Idea:** walk once and flip every arrow.

**Why it is correct (the invariant):** before each loop step, `previous` is the head of the already-reversed front part,
and `current` is the head of the untouched rest. One step moves one node from the rest to the front of the reversed
part. When `current` is `null`, everything is reversed and `previous` is the new head.

**The classic bug:** setting `current.next = previous` *before* saving `current.next` loses the rest of the list.

**Cost:** **O(n) time, O(1) extra space.** A recursive version is also O(n) time but uses O(n) call-stack space, which
fails for very long lists (`StackOverflowError`).
