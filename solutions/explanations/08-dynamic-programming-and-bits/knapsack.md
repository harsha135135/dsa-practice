# 8.1 Build 0/1 knapsack: explanation

**Table meaning:** after handling the first k items, `best[c]` = the most value that fits in capacity `c` using only those k items.

**The step:** for item k+1 with weight w and value v, the best for capacity c either skips it (`best[c]` unchanged) or takes it
(`v + best[c − w]` from **before** this item). Taking the maximum covers both.

**Why loop c downwards:** `best[c − w]` must still be the "before this item" value. Going down, `c − w < c` has not been
updated yet for this item. Going **up** would reuse the item many times; that is the *unbounded* knapsack.

**Why greedy fails:** "best value per weight first" fails on the second example.

**Cost:** **O(n · capacity) time**, O(capacity) space. Note this depends on the *number* `capacity`, not just the input size.
