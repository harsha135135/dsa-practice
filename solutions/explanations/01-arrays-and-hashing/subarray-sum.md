# 1.4 Subarray sum: explanation

**Simple way:** for every start, extend the end and keep a running sum. Cost: O(n²).

**Bottleneck:** for each end `j`, we look for earlier starts one by one.

**Better:** with running totals, run `(i+1 .. j)` sums to `k` exactly when `total(j) - total(i) = k`.
So for each `j`, the number of good runs ending at `j` is **how many earlier totals equal `total(j) - k`**.
A map from total to "times seen" answers that in one lookup.

**Why it is correct:** every run ending at `j` is counted exactly once, through the one earlier total
(position `i`, or "before the start" for `{0: 1}`) where it begins. Runs ending at different `j` are counted
at different steps, so nothing is counted twice.

**Why not a sliding window?** A window works only when all numbers are positive, because then growing the
window always increases the sum. Negative numbers break that, and prefix totals do not care.

**Cost:** O(n) average time, O(n) space.
