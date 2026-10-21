# 5.1 Build a min-heap: explanation

**The rule (heap property):** every parent ≤ its children. So the smallest value is at index 0.

**Why an array:** a heap is always a *complete* tree (filled level by level), so it fits an array with no gaps, and
parent and children are found by arithmetic. There are no node objects or pointers.

**add:** put the value in the only free spot (the end), which may break the rule between it and its parent. Swap
upwards until it holds. Each swap moves one level up: **O(log n)**.

**poll:** the answer is at index 0. Fill the hole with the last value (the shape stays complete), then swap it
down with the smaller child until the rule holds. Choosing the **smaller** child keeps that child ≤ the other.
**O(log n)**.

**Why the height is log n:** a complete tree with n nodes has about log₂ n levels.

**Cost:** `peek` O(1); `add` and `poll` O(log n) (plus occasional O(n) growth, which averages out to O(1) per add); O(n) space.
