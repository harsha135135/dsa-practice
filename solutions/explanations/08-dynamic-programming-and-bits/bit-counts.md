# 8.5 Bit counts: explanation

**This is DP using bits.**

**Simple way:** for each number, count its bits by shifting: O(log i) each, O(n log n) total.

**Better:** `i >> 1` is `i` without its last bit, and it is smaller than `i`, so its count is already in the table.
`i & 1` is that last bit. So `ones[i] = ones[i >> 1] + (i & 1)`.

**Why it is correct:** the bits of `i` are the bits of `i >> 1` plus the last bit, so the counts add up the same way.
Filling upwards means `ones[i >> 1]` is always ready.

**Cost:** **O(n) time**, O(n) space for the answer.

**Another formula:** `ones[i] = ones[i & (i − 1)] + 1`, since `i & (i − 1)` clears the lowest 1-bit.
