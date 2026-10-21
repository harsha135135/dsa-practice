# 8.4 Edit distance: explanation

**Table meaning:** `cost[i][j]` = the fewest edits turning `a[0..i)` into `b[0..j)`.

**Why the formula is correct:** look at how the last letter of `b[0..j)` is produced in a best edit sequence:
- the last letters already match, so nothing is needed for them: `cost[i−1][j−1]`;
- replace `a`'s last letter with it: `1 + cost[i−1][j−1]`;
- delete `a`'s last letter and solve the rest: `1 + cost[i−1][j]`;
- insert it at the end: `1 + cost[i][j−1]`.

Every edit sequence ends in one of these ways, so the minimum over them is the answer.

**Cost:** **O(|a| · |b|) time and space** (two rows are enough if you only need the number).

**Where it is used:** spell checking ("did you mean?"), fuzzy search, comparing DNA.
