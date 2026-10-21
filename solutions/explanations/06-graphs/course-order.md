# 6.3 Course order: explanation

**This is topological sorting (Kahn's method).**

**Why it is correct:** a course is taken only when its unmet count is 0, meaning every prerequisite is already in the
order. The priority queue always picks the smallest ready course, which is what the rule requires.

**Why it detects cycles:** courses in a cycle each wait on another course in the same cycle, so none of them ever
reaches 0. They never enter the order, and the order ends up shorter than `n`.

**Cost:** each course enters and leaves the priority queue once (O(log n) each) and each pair is handled once:
**O((n + p) log n) time**, O(n + p) space. With a plain queue (any order allowed) it would be O(n + p).

**DFS alternative:** a depth-first search that adds each course after all courses it leads to, then reverses the list,
also gives a topological order.
