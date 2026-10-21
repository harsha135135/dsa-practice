# 1.1 Prefix sums: explanation

**Simple way:** add up `values[from..to]` for each question. Cost: O(length of the stretch) per question,
so up to O(n) each and O(n · q) for q questions.

**Bottleneck:** the same numbers are added again and again by different questions.

**Better:** add everything up **once**. `prefix[i]` = sum of the first `i` values, built in one pass.

**Why it is correct:** `prefix[to + 1]` is the sum of `values[0..to]`, and `prefix[from]` is the sum of
`values[0..from-1]`. Subtracting removes exactly the part before `from`, leaving `values[from..to]`.

**Cost:** building is O(n) time and O(n) extra space. Each question is O(1).

**Watch out:** use `long`, because the sum of many `int`s can be larger than `int` can hold.
