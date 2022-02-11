package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class BinarySearchTreeTest {

    @Test
    public void TestBST1(){
        BST tester = new BST("7 3 9 2 5 8 10 1 6");
        tester.add(4);
        String expectation = "7 3 2 1 5 4 6 9 8 10";
        assertEquals(expectation, tester.showTree());
    }

    @Test
    public void TestBST2(){
        BST tester = new BST("7 3 9 2 5 8 10 1 4 6");
        assertEquals(4, tester.search(4).value);
        assertNull(tester.search(11));

    }

    @Test
    public void TestBST3(){
        BST tester = new BST("7 3 9 2 5 8 10 1 4 6");
        String expectation = tester.showNeighbours(7);
        assertEquals(expectation,"Предок: " +
                "-" +
                ",\nЛевый потомок: " +
                3 +
                ",\nПравый потомок: " +
                9 +
                ".");
        expectation = tester.showNeighbours(5);
        assertEquals(expectation,"Предок: " +
                3 +
                ",\nЛевый потомок: " +
                4 +
                ",\nПравый потомок: " +
                6 +
                ".");
        expectation = tester.showNeighbours(1);
        assertEquals(expectation,"Предок: " +
                2 +
                ",\nЛевый потомок: " +
                "-" +
                ",\nПравый потомок: " +
                "-" +
                ".");
    }

        @Test
        public void TestBST4() {
            BST tester = new BST("7 3 9 2 5 8 10 1 4 6");
            tester.delete(1);
            String expectation = "7 3 2 5 4 6 9 8 10";
            assertEquals(expectation, tester.showTree());
        }
}
