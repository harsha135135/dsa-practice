# 2.3 Three sum: explanation

**Simple way:** three nested loops, plus a set to remove repeats. O(n³).

**Bottleneck:** for each pair we search for the third number one by one.

**Better:** sort (O(n log n)). For each first value, find pairs in the rest with two pointers in O(n).

**Why two pointers are correct:** in a sorted range, if `sorted[left] + sorted[right]` is too small, then
`sorted[left]` cannot pair with *any* value, since `right` is already the largest, so `left` can move on safely.
The mirror argument works for "too big". No valid pair is ever skipped.

**No repeats:** a triple is found once per different first value (skip equal `i`), and once per different
second value (skip equal `left` after a match).

**Cost:** **O(n²) time**, O(n) space for the sorted copy (O(1) if you may sort the input).
