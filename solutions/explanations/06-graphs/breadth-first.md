# 6.1 Build breadth-first search: explanation

**Why BFS gives shortest distances:** the queue always holds nodes at distance d, followed by nodes at distance d + 1, never
anything else. So nodes are reached in order of distance, and the **first** time a node is reached is along a shortest path.

**Why mark when adding:** if you marked when removing, a node could be added to the queue several times by different
neighbours. That would still be correct, but slower.

**Cost:** each node is added once and each edge is looked at twice (once from each end): **O(n + e) time and space.**

**Limits of BFS:** it counts edges. If edges have different lengths (minutes, kilometres), you need Dijkstra (topic 7).
