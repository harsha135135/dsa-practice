# 7.2 Extra connection: explanation

**Idea:** add edges in input order with union-find. An edge whose ends are already connected closes a cycle.

**Why it is correct:** there is exactly one cycle. While adding edges in order, the cycle is completed by whichever of its edges
comes **last** in the input. That edge is the first one to find its ends already connected. Removing it leaves the other
`n − 1` edges with no cycle and everything connected: a tree. Since it is the last cycle edge, it is the required answer.

**Cost:** n union-find operations: **almost O(n)** time, O(n) space.
