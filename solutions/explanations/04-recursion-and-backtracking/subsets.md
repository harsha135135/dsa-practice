# 4.2 Subsets: explanation

**Two ways to see it:**
1. **Bits:** count from 0 to 2ⁿ − 1; bit i says whether value i is in. (The test uses this to check you.)
2. **Backtracking:** record every partial choice, and only extend with values to the right of the last one used.

**Why the backtracking version is correct:** each subset, written sorted, has exactly one path: add its smallest
element, then its next, and so on. Only moving right means no subset is produced twice, and recording before
extending produces each one in dictionary order (a prefix is recorded before its extensions).

**Cost:** 2ⁿ subsets, each copied in O(n): **O(n · 2ⁿ) time**, O(n) recursion space.
