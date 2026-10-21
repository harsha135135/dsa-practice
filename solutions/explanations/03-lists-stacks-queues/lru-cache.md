# 3.4 LRU cache: explanation

**Simple way:** keep a list of keys in order of use; on each use, find the key and move it. Finding is O(n).

**Better:** combine two structures, each doing what it is good at:
- `HashMap<key, node>` jumps straight to a key's node: O(1).
- A **doubly linked list** of nodes in order of use: unlinking a node you hold and relinking it at the front is O(1),
  because each node knows both neighbours.

**Why it is correct (the invariant):** the map and the list always contain the same keys; the list runs from most
recently used (front) to least (back). `get` and `put` move the used node to the front; when over capacity, the back
node is exactly the least recently used.

**Cost:** **O(1) average** per operation, O(capacity) space.

**Real life:** this is the idea behind many caches; Java's `LinkedHashMap(accessOrder = true)` implements it for you.
