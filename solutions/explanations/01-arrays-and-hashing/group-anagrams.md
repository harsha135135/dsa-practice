# 1.3 Group anagrams: explanation

**Simple way:** for each word, compare it with every group's first word ("same letters?"). Cost: O(n² · L).

**Bottleneck:** comparing each word with many others.

**Better:** give each word a **label**, its sorted letters. Anagrams, and only anagrams, get the same label.
Group with `Map<label, list of words>`.

**Why it is correct:** two words are anagrams exactly when they contain the same letters the same number of
times, which is exactly when their sorted letters are equal. So equal labels mean the same group, and
different labels mean different groups.

**Cost:** making a label is O(L log L) for a word of length L, so O(n · L log L) in total, plus sorting the
output. Space is O(n · L).

**Another option:** for lowercase letters, a label of 26 letter counts costs O(L) instead of O(L log L).
