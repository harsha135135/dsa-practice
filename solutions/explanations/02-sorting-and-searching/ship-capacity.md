# 2.4 Ship capacity: explanation

**Simple way:** try capacities 1, 2, 3, ... and check each. Up to sum(weights) checks: far too many.

**Key observation:** more capacity never needs more days. So "works?" goes no...no, yes...yes as capacity grows,
and binary search can find the first yes. This is called **binary search on the answer**.

**Why the daily check is correct:** loading each day as full as possible (greedy) uses the fewest days for a
given capacity. Any schedule can be shifted to load earlier days fuller without needing more days.

**Cost:** each check is O(n); binary search needs O(log(sum)) checks. **O(n log(sum)) time, O(1) space.**

**The pattern:** whenever a question asks for "the smallest X such that ...", ask whether the "..." is monotonic in X.
