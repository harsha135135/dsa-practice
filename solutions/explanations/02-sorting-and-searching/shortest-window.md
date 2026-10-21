# 2.5 Shortest window with every kind: explanation

**This is a sliding window.**

**Simple way:** for each start, extend until every kind is present. O(n²).

**Better:** both edges of the window only move forward. For each `right`, shrink `left` as far as the window stays
complete. Recording the length just before it becomes incomplete gives the shortest complete window ending at `right`.

**Why it is correct:** when `right` moves forward, the best `left` for it can only be the same or further right
(a window that was complete stays complete when extended), so `left` never needs to move back. Every candidate
"shortest window ending at `right`" is therefore checked.

**Cost:** each index enters and leaves the window once: **O(n) average time**, O(k) space for k kinds.
