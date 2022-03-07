package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    @Test
    public void testTicTacToe() {
        TicTacToe field = new TicTacToe(3);
        TicTacToe.Element moveX = TicTacToe.Element.X;
        TicTacToe.Element moveO = TicTacToe.Element.O;
        TicTacToe.Element clear = null;
        field.addOrClear(1, 1, moveX);
        field.addOrClear(1, 2, moveX);
        field.addOrClear(1, 3, moveO);
        field.addOrClear(2, 1, moveO);
        field.addOrClear(2, 2, moveX);
        field.addOrClear(2, 3, moveX);
        field.addOrClear(3, 1, moveO);
        field.addOrClear(3, 2, moveO);
        field.addOrClear(3, 2, clear);
        field.addOrClear(3, 3, moveX);
        assertEquals(3, field.largestLine(moveX));
        assertEquals(2, field.largestLine(moveO));
    }
}