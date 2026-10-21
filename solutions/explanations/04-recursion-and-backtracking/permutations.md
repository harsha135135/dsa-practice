# 4.1 Build permutations: explanation

**Backtracking template:**
```
build(current):
    if current is complete: record a copy; return
    for each choice still allowed:
        choose it      (add to current, mark used)
        build(current) (explore)
        undo it        (remove, unmark)
```

**Why it is correct:** the recursion forms a tree. Level k picks the value at position k, and each path from the
root to a leaf is one ordering. Every value is tried at every position not yet filled, so every ordering appears,
and the "used" marks prevent repeats. Trying values in sorted order visits the leaves in dictionary order.

**Why copy:** `current` keeps changing. Recording `current` itself would leave n! references to the same list,
which is empty at the end.

**Cost:** n! orderings, each copied in O(n): **O(n · n!) time**. O(n) extra space for the recursion (plus the output).
