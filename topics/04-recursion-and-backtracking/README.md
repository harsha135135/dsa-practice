# Topic 4: recursion and backtracking

## Ideas to know

- **Recursion:** a method that solves a problem by calling itself on a smaller version, plus a **base case** that stops it.
- **Backtracking:** build an answer step by step; at each step **choose**, **explore** deeper, then **undo** the choice and try the next one.
- **Pruning:** stop exploring a branch as soon as it cannot lead to an answer. This is where most of the speed comes from.
- These problems often have exponentially many answers (n!, 2ⁿ). Then no method is fast in general; the goal is to waste no work.

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build permutations](1-build-permutations.md) | build it | `Permutations` |
| 2 | [Subsets](2-subsets.md) | warm-up | `Subsets` |
| 3 | [Combination sum](3-combination-sum.md) | standard | `CombinationSum` |
| 4 | [N queens](4-queens.md) | harder | `Queens` |
| 5 | [Word in a grid](5-later-word-in-grid.md) | do it **at least a week later** | `WordInGrid` |

Your code goes in `src/main/java/practice/recursion/`. Run one exercise's tests with
`./mvnw test -Dtest=<Class>Test`.
