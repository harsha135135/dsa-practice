# Topic 7: shortest paths, union-find and greedy reasoning

## Ideas to know

- **Union-find (disjoint sets):** keeps items in groups and answers "same group?" and "join these groups" in almost O(1).
- **Dijkstra:** shortest paths when edges have different (non-negative) lengths. Settle the closest unsettled node first, using a priority queue.
- **Minimum spanning tree (Kruskal):** connect everything as cheaply as possible: take links cheapest first, and skip any link that would join two already-connected nodes.
- **Greedy:** make the choice that looks best right now and never undo it. It is only correct when you can **prove** the local choice is safe. Always look for a counter-example first.

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build union-find](1-build-union-find.md) | build it | `UnionFind` |
| 2 | [Extra connection](2-extra-connection.md) | warm-up | `ExtraConnection` |
| 3 | [Network delay](3-network-delay.md) | standard | `NetworkDelay` |
| 4 | [Cheapest network](4-cheapest-network.md) | harder | `CheapestNetwork` |
| 5 | [Fewest removals](5-later-fewest-removals.md) | do it **at least a week later** | `FewestRemovals` |

Your code goes in `src/main/java/practice/paths/`. Run one exercise's tests with
`./mvnw test -Dtest=<Class>Test`.
