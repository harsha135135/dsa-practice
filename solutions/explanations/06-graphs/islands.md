# 6.2 Count islands: explanation

**Idea:** count the times a flood fill has to *start*.

**Why it is correct:** each flood fill marks exactly the land cells reachable from its start, which is one whole
island. The scan starts a new fill only on unmarked land, which belongs to an island not yet counted. So each
island is counted exactly once.

**Why not recursion here:** recursive DFS on a 1000 × 1000 all-land grid can go a million calls deep, and Java's
default call stack overflows. An explicit `ArrayDeque` lives on the heap and has no such limit. (BFS with a queue works too.)

**Cost:** each cell is visited a constant number of times: **O(rows × cols) time and space.**

**Another way:** union-find (topic 7) can merge neighbouring land cells and count the groups.
