# 5.4 Prefix counter (trie) (harder)

**Write it in:** `src/main/java/practice/trees/PrefixCounter.java` · **Test:** `./mvnw test -Dtest=PrefixCounterTest`

## Problem

Build a word store for lowercase words (`a` to `z`):
- `add(word)`: words may be added more than once.
- `contains(word)`: true if this exact word was added.
- `countWithPrefix(prefix)`: how many added words (repeats counted) start with `prefix`. Every word starts with `""`.

Each call must take time proportional to the length of its word or prefix, not to the number of words stored.

## Examples

After adding `apple, app, apply, bat`:

| call | answer |
|---|---|
| `contains("app")` | `true` |
| `contains("ap")` | `false` |
| `countWithPrefix("app")` | `3` |
| `countWithPrefix("")` | `4` |

## Limits

Thousands of words and queries, compared with checking every word.

## Hints

<details><summary>Hint 1: a nudge</summary>

Words that start the same way could share storage for the shared part.
</details>

<details><summary>Hint 2: the approach</summary>

A tree where each node is one prefix and each edge is one letter. Store in each node how many words **pass through** it and how many **end** at it.
</details>

<details><summary>Hint 3: almost the answer</summary>

Node: `Node[26] children`, `int passing`, `int ending`. `add`: walk down (creating nodes), `passing++` on every node including the root, `ending++` at the end. Queries walk down and read the counts.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/05-trees-heaps-tries/prefix-counter.md`.
