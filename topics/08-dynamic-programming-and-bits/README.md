# Topic 8: dynamic programming and bit operations

## Ideas to know

- **Dynamic programming (DP):** when a problem breaks into smaller problems that **repeat**, solve each small problem once, store its answer in a table, and build bigger answers from smaller ones.
- The work is in **defining the table**: "`cost[i][j]` means ...". Once the meaning is exact, the formula usually follows.
- Fill the table in an order where the entries you need are already filled.
- **Bit operations:** `&` (and), `|` (or), `^` (xor), `>>` and `<<` (shift). `x ^ x == 0`; `i >> 1` drops the last bit; `i & 1` reads the last bit.

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build 0/1 knapsack](1-build-knapsack.md) | build it | `Knapsack` |
| 2 | [Lone number](2-lone-number.md) | warm-up | `LoneNumber` |
| 3 | [Longest common subsequence](3-common-subsequence.md) | standard | `CommonSubsequence` |
| 4 | [Edit distance](4-edit-distance.md) | harder | `EditDistance` |
| 5 | [Bit counts](5-later-bit-counts.md) | do it **at least a week later** | `BitCounts` |

Your code goes in `src/main/java/practice/dp/`. Run one exercise's tests with
`./mvnw test -Dtest=<Class>Test`.
