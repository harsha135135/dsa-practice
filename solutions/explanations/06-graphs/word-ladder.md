# 6.4 Word ladder: explanation

**This is BFS on a graph you never build.**

**Building the graph naively** (compare every pair of words) costs O(n² · L). Instead, generate a word's possible
neighbours on the fly: L positions × 26 letters, each checked in a `HashSet`.

**Why BFS:** each step costs 1, so the first time `end` is reached is along a shortest chain. Processing one ring at a time
gives the chain length directly.

**Why remove words from the set:** that is the visited mark. A word reached once is never queued again.

**Cost:** each word is processed once, producing 26 · L candidates of length L: **O(n · 26 · L²) time**, O(n · L) space.

**Faster in practice:** search from both ends at once (bidirectional BFS).
