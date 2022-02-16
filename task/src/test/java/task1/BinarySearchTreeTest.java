package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    public class BinarySearchTreeTest {

    @Test
    public void addTest(){
        BST tester = new BST("7 3 9 2 5 8 10 1 6");
        tester.add(4);
        String expectation = "7 3 2 1 5 4 6 9 8 10";
        assertEquals(expectation, tester.toString());
    }

    @Test
    public void searchTest(){
        BST tester = new BST("7 3 9 2 5 8 10 1 4 6");
        assertEquals(4, tester.search(4).value);
        assertNull(tester.search(11));

    }

    @Test
    public void showNeighboursTest(){
        BST tester = new BST("7 3 9 2 5 8 10 1 4 6");
        List<Integer> expectation = new ArrayList<>();
        expectation.add(3);
        expectation.add(4);
        expectation.add(6);
        List<Integer> betweener = new ArrayList<>();
        for (BST.Node cur : tester.showNeighbours(5)){
            if (cur!=null) betweener.add(cur.value);
        }
        assertEquals(expectation, betweener);
    }

        @Test
        public void deleteTest() {
            BST tester = new BST("7 3 9 2 5 8 10 1 4 6");
            tester.delete(1);
            String expectation = "7 3 2 5 4 6 9 8 10";
            assertEquals(expectation, tester.toString());
        }
}
