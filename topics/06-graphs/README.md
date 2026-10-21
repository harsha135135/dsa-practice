# Topic 6: graphs, BFS, DFS, topological sorting

## Ideas to know

- **Graph:** things (nodes) and connections (edges). Store it as an **adjacency list**: for each node, a list of its neighbours.
- **BFS (breadth-first search):** explore in rings using a **queue**: everything 1 step away, then 2, and so on. It finds shortest paths when every edge counts as 1.
- **DFS (depth-first search):** go as deep as possible, then back up, using a **stack** or recursion. Good for "is it connected?" and for exploring regions.
- **Visited marks:** without them, a graph with a cycle loops forever.
- **Topological order:** an order where every arrow points forward, like courses after their prerequisites. It is only possible without cycles.
- A grid is a graph too: cells are nodes, and neighbouring cells are joined.

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build breadth-first search](1-build-breadth-first.md) | build it | `BreadthFirst` |
| 2 | [Count islands](2-islands.md) | warm-up | `Islands` |
| 3 | [Course order](3-course-order.md) | standard | `CourseOrder` |
| 4 | [Word ladder](4-word-ladder.md) | harder | `WordLadder` |
| 5 | [Spreading](5-later-spreading.md) | do it **at least a week later** | `Spreading` |

Your code goes in `src/main/java/practice/graphs/`. Run one exercise's tests with
`./mvnw test -Dtest=<Class>Test`.
