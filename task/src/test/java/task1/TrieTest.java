package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrieTest {

    @Test
    public void testTrie() {
        Trie trie = new Trie();
        trie.insert("go");
        trie.insert("god");
        trie.insert("good");
        trie.insert("goodness");

        boolean expectedSearch1 = true;
        assertEquals(expectedSearch1, trie.search("go"));

        List<String> expectedList1 = new ArrayList<>();
        expectedList1.add("good");
        expectedList1.add("goodness");
        assertEquals(expectedList1, trie.searchByPrefix("goo"));

        trie.delete("god");
        boolean expectedSearch2 = false;
        assertEquals(expectedSearch2, trie.search("god"));

        List<String> expectedList2 = new ArrayList<>();
        expectedList2.add("go");
        expectedList2.add("good");
        expectedList2.add("goodness");
        assertEquals(expectedList2, trie.searchByPrefix("g"));

    }
}
