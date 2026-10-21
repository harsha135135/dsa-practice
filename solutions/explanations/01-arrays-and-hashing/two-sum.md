# 1.2 Two sum: explanation

**Simple way:** check every pair `i < j`. Cost: O(n²) time, O(1) space.

**Bottleneck:** for each `j`, we search all earlier numbers for one value, `target - numbers[j]`.

**Better:** keep a hash map from value to index for the numbers already passed. The search becomes one lookup.

**Why it is correct:** suppose a pair `(i, j)` exists. When the loop reaches `j`, `numbers[i]` was stored at
step `i < j`, so the lookup finds a match, and the method returns some valid pair no later than `j`.
Any pair it returns is valid, because it was found by lookup, so `numbers[i] + numbers[j] == target`.
Looking up before storing means `i < j`, so a number never pairs with itself.

**Cost:** O(n) time on average (each map step is O(1) on average) and O(n) extra space.
This trades memory for time.
