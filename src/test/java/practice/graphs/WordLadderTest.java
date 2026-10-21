package practice.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordLadderTest {

    @Test
    void examples() {
        List<String> words = List.of("hot", "dot", "dog", "lot", "log", "cog");

        assertEquals(5, WordLadder.shortest("hit", "cog", words), "hit → hot → dot → dog → cog");
        assertEquals(0, WordLadder.shortest("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")), "cog is not a word");
    }

    @Test
    void endOneStepAway() {
        assertEquals(2, WordLadder.shortest("a", "c", List.of("a", "b", "c")));
    }

    @Test
    void beginEqualsEnd() {
        assertEquals(1, WordLadder.shortest("cat", "cat", List.of("cat")));
    }

    @Test
    void noChainAtAll() {
        assertEquals(0, WordLadder.shortest("aaa", "zzz", List.of("aab", "zzz")));
    }

    @Test
    void picksTheShortestOfSeveralChains() {
        List<String> words = List.of("bat", "bot", "bog", "cag", "cog", "cot", "cat");
        // cat → cot → cog is shorter than cat → bat → bot → bog → cog
        assertEquals(3, WordLadder.shortest("cat", "cog", words));
    }
}
