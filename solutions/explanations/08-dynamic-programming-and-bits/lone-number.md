# 8.2 Lone number: explanation

**Simple way:** a `HashMap` of counts. O(n) time but O(n) memory.

**With bits:** XOR works bit by bit: a result bit is 1 when the two input bits differ. So `x ^ x = 0` and `x ^ 0 = x`, and XOR is
**commutative** and **associative** (the order and grouping do not matter). XOR-ing everything is the same as XOR-ing each pair
together (giving 0) and then the lone number: `0 ^ lone = lone`.

**Cost:** **O(n) time, O(1) space.**

**Works for negatives too:** XOR does not care what the bits mean.
