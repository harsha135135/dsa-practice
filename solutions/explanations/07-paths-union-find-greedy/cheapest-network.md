# 7.4 Cheapest network: explanation

**This is a minimum spanning tree, found with Kruskal's algorithm, a greedy method.**

**Why no cycles:** in a cycle, removing any one link keeps everything connected and does not cost more. So a cheapest network is a tree.

**Why greedy works here (the cut argument):** take the cheapest link that joins two separate groups. Any network connecting
everything must cross between those groups somewhere; swapping that crossing link for our cheaper (or equal) one never costs
more. So taking it is always safe.

**Why union-find:** "does this link join two separate groups?" is exactly `union` returning `true`.

**Cost:** sorting O(e log e) dominates: **O(e log e) time**, O(n + e) space.
