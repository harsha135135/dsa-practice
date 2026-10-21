# Glossary

| Word | Meaning |
|---|---|
| **Algorithm** | A precise list of steps that solves a problem. |
| **Data structure** | A way of arranging data so certain questions are fast (array, map, heap, tree...). |
| **Big-O, e.g. O(n)** | How the work grows as the input grows, ignoring constant factors. O(n): double the input, roughly double the work. |
| **O(1)** | Constant: the same work whatever the input size. |
| **O(log n)** | Grows very slowly: doubling the input adds one step (binary search). |
| **O(n log n)** | Typical of good sorting. |
| **O(n²)** | Every pair: doubling the input makes it about 4 times slower. |
| **O(2ⁿ), O(n!)** | Exponential: only usable for very small inputs. |
| **Average vs worst case** | Hash maps are O(1) on average, but can be slower in rare bad cases. |
| **Brute force** | Trying every possibility. Slow, but a great way to check a faster solution. |
| **Bottleneck** | The part of a solution that takes most of the time. |
| **Invariant** | Something that is true before and after every step of a loop. It is the usual way to prove a loop is correct. |
| **Recursion** | A method calling itself on a smaller version of the problem. |
| **Base case** | The smallest version, answered directly, which stops the recursion. |
| **Backtracking** | Try a choice, explore, undo, try the next choice. |
| **Greedy** | Always take the choice that looks best right now, and never undo it. It needs a proof. |
| **Dynamic programming** | Solve each smaller sub-problem once, store the answer, and build up. |
| **Stub** | A placeholder method that compiles but does nothing useful yet. |
| **Seeded random** | A random-number generator started from a fixed number, so it produces the same "random" values every run. |
| **Maven profile** | A named set of build settings, switched on with `-P<name>`. |
