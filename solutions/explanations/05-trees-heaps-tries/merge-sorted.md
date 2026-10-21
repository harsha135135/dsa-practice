# 5.5 Merge sorted arrays: explanation

**This is a heap problem.**

**Simple ways:** join everything and sort: O(N log N) for N values in total. Or merge arrays two at a time,
one after another, which can be O(N · k).

**Better:** a heap holds each array's current front value. The smallest front is always on top. Poll it, write it,
and push that array's next value.

**Why it is correct:** the next value of the merged output must be the smallest remaining value. Each array is
sorted, so the smallest remaining value is one of the k fronts, which is exactly what the heap's top is.

**Cost:** the heap holds at most k items, so each push or poll is O(log k): **O(N log k) time**, O(k) extra space
(plus the output).

**Where you will meet it again:** the search-engine project merges sorted posting lists the same way.
