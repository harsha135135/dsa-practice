# 2.2 First and last position: explanation

**Simple way:** scan left to right. O(n).

**Better:** binary search for an *edge*. `firstIndexAtLeast(x)` keeps a range `[low, high]` that always contains
the answer. Looking at `middle`: if `sorted[middle] < x`, the answer is to the right (`low = middle + 1`);
otherwise `middle` might be the answer (`high = middle`). The range shrinks every step and stops when `low == high`.

**Why it is correct:** the "always contains the answer" rule (the invariant) holds at the start (`[0, n]`) and after
every step, and the loop ends with a range of one position, which must be the answer.

**Cost:** two binary searches, **O(log n) time, O(1) space.**

**Common mistakes:** `(low + high) / 2` can overflow for huge arrays (use `>>> 1`); `high = middle - 1` skips the answer;
`target + 1` overflows at `Integer.MAX_VALUE` (use `long`).
