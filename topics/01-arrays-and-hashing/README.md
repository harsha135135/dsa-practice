# Topic 1: arrays, strings, hash maps, prefix sums

## Ideas to know

- **Array:** numbered boxes in a row. Reading box `i` is instant.
- **Hash map:** a lookup table. "Have I seen this value before, and where?" is answered in about one step.
- **Prefix sum:** a running total. With it, the sum of any stretch of an array is one subtraction.
- The usual upgrade in this topic: replace "check every pair" (O(n²)) with "remember what I have seen" (O(n)).

## Exercises

| # | Exercise | Kind | Class |
|---|---|---|---|
| 1 | [Build prefix sums](1-build-prefix-sums.md) | build it | `PrefixSums` |
| 2 | [Two sum](2-two-sum.md) | warm-up | `TwoSum` |
| 3 | [Group anagrams](3-group-anagrams.md) | standard | `GroupAnagrams` |
| 4 | [Subarray sum](4-subarray-sum.md) | harder | `SubarraySum` |
| 5 | [Balanced run](5-later-balanced-run.md) | do it **at least a week later** | `BalancedRun` |

Your code goes in `src/main/java/practice/arrays/`. Run one exercise's tests with
`./mvnw test -Dtest=TwoSumTest`.
