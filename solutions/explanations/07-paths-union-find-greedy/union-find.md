# 7.1 Build union-find: explanation

**The idea:** each group is a tree of parent pointers; the root names the group.

**Why the two tricks matter:**
- **Union by size:** a node's depth grows only when its tree is hung under a bigger one, which at least doubles the size of
  its tree. That can happen at most log₂ n times, so trees never get deeper than log n.
- **Path compression:** after a `find`, every node on the path points straight at the root, so the next `find` is one step.

Together they make each operation take **almost O(1) on average** (the exact bound is the inverse Ackermann function, which is
below 5 for any real input).

**Why it is correct:** `union` only ever links two roots, so each group stays one tree with one root, and `find` always reaches it.
`groups` drops by one exactly when two different groups join.

**Space:** O(n).
