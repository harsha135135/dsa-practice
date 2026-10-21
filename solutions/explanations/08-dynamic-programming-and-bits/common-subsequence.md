# 8.3 Longest common subsequence: explanation

**Plain recursion** on (rest of a, rest of b) recomputes the same pairs of prefixes exponentially often.
The test uses it only on short strings.

**DP:** there are only `(|a| + 1) × (|b| + 1)` different prefix pairs. Store each answer once.

**Why the formula is correct:**
- If the last letters match, some longest common subsequence uses them both (any that does not could swap them in),
  so the answer is 1 + the answer without them.
- If they differ, a common subsequence cannot end with both, so one of the two last letters is unused: take the better of dropping either.

**Cost:** **O(|a| · |b|) time and space** (space can be cut to two rows).

**Where it is used:** `diff` tools, DNA comparison.
