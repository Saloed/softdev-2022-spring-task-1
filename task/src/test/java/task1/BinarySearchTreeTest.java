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
        assertEquals(3, tester.search(7).showLeft().value);
        assertNull(tester.search(7).showParent());
        assertEquals(5,tester.search(3).showRight().value);
    }

        @Test
        public void deleteTest() {
            BST tester = new BST("7 3 9 2 5 8 10 1 4 6");
            tester.delete(1);
            String expectation = "7 3 2 5 4 6 9 8 10";
            assertEquals(expectation, tester.toString());
        }
}
