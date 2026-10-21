# 4.5 Word in a grid: explanation

**This is backtracking on a grid:** choose a neighbour, explore, undo.

**Why unmark:** a path that fails must give its cells back. Another path, through the same cell in a different
order, may succeed. (The test `aFailedPathFreesItsCellsForOtherPaths` checks this.)

**Why it is correct:** every way of spelling the word is a path of neighbouring, distinct cells; the search tries
every start and every neighbour in turn, and only rejects a path when it breaks a rule.

**Cost:** for an R × C grid and a word of length L: at most R·C starts, each exploring up to 4 · 3^(L−1) paths
(after the first step, you cannot go back). **O(R · C · 3^L) time**, O(L) recursion space plus the marks.
