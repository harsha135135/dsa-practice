# 5.2 Tree depth: explanation

**Recursion on trees:** solve for each subtree, then combine.

**Why it is correct:** the longest path from the root goes through the root and then down the deeper subtree.
The empty tree has depth 0, which stops the recursion.

**Cost:** each node is visited once: **O(n) time**. Space is the recursion depth, O(h) for a tree of height h:
O(log n) for a balanced tree, O(n) for a chain.

**Without recursion:** a breadth-first walk level by level (topic 6) counts the levels.
