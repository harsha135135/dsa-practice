# 7.5 Fewest removals: explanation

**This is a greedy problem: interval scheduling.**

**Rules that fail:**
- Shortest first fails on `{1,5} {4,7} {6,10}`: keeping `{4,7}` blocks both others.
- Earliest start first fails on `{1,100} {2,3} {4,5}`.

**The rule that works:** always keep the interval that **ends first**.

**Why it is correct (exchange argument):** take any best set of kept intervals, sorted by end. Its first interval ends no earlier
than ours, so swapping ours in overlaps nothing else: still a best set, now agreeing with greedy on the first choice. Repeat the
argument on what is left. So greedy keeps as many as the best possible.

**Cost:** sorting dominates: **O(n log n) time**, O(n) space for the sorted copy.
