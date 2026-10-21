# 7.3 Network delay: explanation

**This is Dijkstra's algorithm.**

**Key fact:** with non-negative lengths, the unsettled node with the smallest known time cannot be improved later, because
any other route to it would go through a node whose time is already at least as big. So it can be settled for good.

**The skip:** a node may be pushed several times with improving times. When an old, worse entry comes out of the
queue, ignore it. This "lazy deletion" is simpler than updating entries inside the queue.

**Why it is correct:** by induction, every settled node has its true shortest time (the key fact above), and every node
reachable from the source is eventually settled.

**Cost:** each link can push one entry: **O(e log e) time**, O(n + e) space.

**Negative lengths break it:** use Bellman-Ford instead (which the test uses as its checker): O(n · e).
