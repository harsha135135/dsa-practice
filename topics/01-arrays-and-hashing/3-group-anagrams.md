# 1.3 Group anagrams (standard)

**Write it in:** `src/main/java/practice/arrays/GroupAnagrams.java` · **Test:** `./mvnw test -Dtest=GroupAnagramsTest`

## Problem

Two words are **anagrams** if one is a rearrangement of the other's letters ("eat", "tea", "ate").
Group the words so that each group holds words that are anagrams of each other.

To make the answer exact:
- sort the words inside each group alphabetically, and
- sort the groups by their first word.

Repeated words stay (both copies go in the same group). The empty string is a word too.

## Examples

| words | answer |
|---|---|
| `eat tea tan ate nat bat` | `[[ate, eat, tea], [bat], [nat, tan]]` |
| `abb aab` | `[[aab], [abb]]` (same letters, different counts) |
| (none) | `[]` |

## Limits

Up to 10,000 words of up to 100 lowercase letters.

## Hints

<details><summary>Hint 1: a nudge</summary>

What do all anagrams of "eat" have in common that other words do not?
</details>

<details><summary>Hint 2: the approach</summary>

Give each word a **label** that is identical for all its anagrams and different for everything else.
Then group by label with a map.
</details>

<details><summary>Hint 3: almost the answer</summary>

The label can be the word's letters sorted: "tea" becomes "aet". Use `Map<String, List<String>>` and
`computeIfAbsent`. Sort at the end.
</details>

## After you solve it

Log it, write your own note, then compare with `solutions/explanations/01-arrays-and-hashing/group-anagrams.md`.
