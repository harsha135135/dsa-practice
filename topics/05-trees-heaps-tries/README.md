# Topic 5: trees, BSTs, heaps and tries

## Ideas to know

- **Binary tree:** each node has at most two children. Most tree code is "do something with this node, then recurse into left and right".
- **Binary search tree (BST):** everything in the left subtree is smaller, everything in the right subtree is bigger. Search goes left or right, like binary search.
- **Heap:** a tree where every parent is ≤ its children, so the smallest value is on top. Stored in a plain array. `add` and `poll` are O(log n). Java: `PriorityQueue`.
- **Trie (prefix tree):** one node per prefix; words that share a start share a path. Answers "how many words start with...?" in O(length of the prefix).

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build a min-heap](1-build-min-heap.md) | build it | `MinHeap` |
| 2 | [Tree depth](2-tree-depth.md) | warm-up | `TreeDepth` |
| 3 | [Valid binary search tree](3-valid-bst.md) | standard | `ValidBst` |
| 4 | [Prefix counter (trie)](4-prefix-counter.md) | harder | `PrefixCounter` |
| 5 | [Merge sorted arrays](5-later-merge-sorted.md) | do it **at least a week later** | `MergeSorted` |

Your code goes in `src/main/java/practice/trees/`. Run one exercise's tests with
`./mvnw test -Dtest=<Class>Test`.
