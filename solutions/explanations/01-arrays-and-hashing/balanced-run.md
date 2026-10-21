# 1.5 Balanced run: explanation

**This is exercise 1.4 in disguise.** Map `1 → +1`, `0 → -1`. A run is balanced exactly when its sum is 0.

**Simple way:** try every run and count 0s and 1s. Cost: O(n²).

**Better:** the running total at the end of a run minus the total just before it is the run's sum. It is 0
exactly when the two totals are **equal**. For the **longest** run ending at `i`, use the **earliest**
position with the same total, so store only the first index of each total (`putIfAbsent`).

**Why it is correct:** for each end `i`, the longest balanced run ending at `i` starts right after the
earliest index with the same total. Taking the maximum over all `i` gives the longest overall.
The starting entry `{0: -1}` covers runs that start at index 0.

**Cost:** O(n) average time, O(n) space.

**The lesson:** "longest run" problems want the **first** occurrence; "count runs" problems (1.4) want **how
many** occurrences. The same running-total idea answers both.
