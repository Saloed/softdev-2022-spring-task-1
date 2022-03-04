package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ticTacToeTest {
    @Test
    public void testTicTacToe() {
        ticTacToe field = new ticTacToe(3);
        field.addOrClear(11, "X");
        field.addOrClear(12, "X");
        field.addOrClear(13, "O");
        field.addOrClear(21, "O");
        field.addOrClear(22, "X");
        field.addOrClear(23, "X");
        field.addOrClear(31, "O");
        field.addOrClear(32, "O");
        field.addOrClear(32, null);
        field.addOrClear(33, "X");
        assertEquals(3, field.largestLine("X"));
        assertEquals(2, field.largestLine("O"));
    }
}