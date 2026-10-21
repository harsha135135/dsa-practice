# 4.3 Combination sum: explanation

**Same template as Subsets, with two changes:** recurse with `i` instead of `i + 1` (so values can repeat), and track
the remaining amount.

**Why each combination appears exactly once:** the picks never move left, so each combination can only be built in
sorted order: one path per combination.

**Pruning:** with sorted candidates, once `sorted[i] > remaining`, no later candidate fits either, so the loop
stops. Without pruning, the search explores many dead branches.

**Cost:** depends on the number of answers; it can be exponential in `target / smallest`. Pruning keeps the work
close to the size of the output.
