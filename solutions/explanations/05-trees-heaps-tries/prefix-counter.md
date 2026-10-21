# 5.4 Prefix counter (trie): explanation

**A trie** stores words letter by letter in a tree; all words with the same prefix share the same path.

**Two counts per node:**
- `passing`: words whose path goes through this node, which is exactly the words with this prefix.
- `ending`: words that stop exactly here, which tells whether the full word was added.

**Why it is correct:** adding a word increments `passing` on exactly the nodes for its prefixes (including the empty
prefix at the root), so `passing` at a prefix's node counts the words with that prefix. A prefix with no node has no words.

**Cost:** `add`, `contains` and `countWithPrefix` are **O(L)** for length L, whatever the number of words. Space can
be large: up to 26 child slots per node.

**Where it is used:** autocomplete, spell checkers, IP routing tables (by bits instead of letters).
