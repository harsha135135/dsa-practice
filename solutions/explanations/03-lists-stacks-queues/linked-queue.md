# 3.1 Build a linked queue: explanation

**Why two pointers:** with only `head`, adding at the back means walking the whole list, which is O(n). Keeping
`tail` makes it O(1). Removing at the head is O(1) in a singly linked list; removing at the tail would not be,
because you cannot step backwards. So: add at the tail, remove at the head.

**Why it is correct (the invariant):** `head` is the oldest item, `tail` the newest, each node's `next` is the next-newer
item, and `size` counts the nodes. `add` and `remove` both keep this true. The tricky case is the empty queue: both
ends are `null`, so `add` must set both, and `remove` of the last item must clear both.

**Cost:** **O(1)** per operation, and O(n) memory for n items.

**Compared with an array:** `ArrayDeque` is usually faster in practice (items sit next to each other in memory),
but needs occasional O(n) resizing. Linked nodes never resize but use more memory per item.
