# 5.3 Valid binary search tree: explanation

**Common wrong solution:** check `left.value < node.value < right.value` at every node. It accepts the second
example, because 3 < 6 locally but 3 is in the right subtree of 5.

**Correct idea:** a node's allowed range is set by **all** its ancestors. Pass the range down: the left child's
upper bound becomes the node's value; the right child's lower bound becomes the node's value.

**Why it is correct:** by induction, every node is checked against exactly the constraints the BST definition
puts on it: smaller than every ancestor it is left of, bigger than every ancestor it is right of.

**Why `long`:** with `int` bounds, you would need a sentinel smaller than `Integer.MIN_VALUE`, which does not exist.

**Another way:** an in-order walk (left, node, right) of a BST visits values in strictly increasing order.

**Cost:** **O(n) time**, O(h) recursion space.
