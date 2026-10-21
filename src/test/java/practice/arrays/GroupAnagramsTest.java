package practice.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    @Test
    void example() {
        List<List<String>> groups = GroupAnagrams.group(List.of("eat", "tea", "tan", "ate", "nat", "bat"));

        assertEquals(List.of(
                List.of("ate", "eat", "tea"),
                List.of("bat"),
                List.of("nat", "tan")), groups);
    }

    @Test
    void emptyInputGivesNoGroups() {
        assertEquals(List.of(), GroupAnagrams.group(List.of()));
    }

    @Test
    void repeatedWordsStayInTheSameGroup() {
        assertEquals(List.of(List.of("ab", "ab", "ba")), GroupAnagrams.group(List.of("ba", "ab", "ab")));
    }

    @Test
    void lettersMustMatchInCountNotJustInKind() {
        assertEquals(List.of(List.of("aab"), List.of("abb")), GroupAnagrams.group(List.of("abb", "aab")));
    }

    @Test
    void emptyStringsFormTheirOwnGroup() {
        assertEquals(List.of(List.of("", ""), List.of("a")), GroupAnagrams.group(List.of("a", "", "")));
    }
}
