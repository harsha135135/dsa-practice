# 2.1 Build merge sort: explanation

**Simple way:** insertion sort: take each value and slide it left into place. Cost: O(n²) in the worst case.

**Bottleneck:** each value may be compared with every value before it.

**Merge sort:** split, sort halves, merge. Merging two sorted lists of total length m takes O(m) steps,
because each step places one value.

**Why it is correct:** by induction on length. Lengths 0 and 1 are sorted. For longer arrays, both halves
are sorted (they are shorter), and merging always takes the smallest remaining front value, which is the
smallest remaining value overall, so the output is sorted.

**Cost:** the array is halved about log₂ n times, and each level of halving does O(n) merging work in total:
**O(n log n) time** in every case. **O(n) extra space** for the buffer.

**Stable:** on ties, taking from the left half first keeps equal values in their original order. That matters
when sorting records by one field.
