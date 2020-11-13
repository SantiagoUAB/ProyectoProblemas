package ProyectoProblemas;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class BoardTest {
	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();
	}
	
	
    @Test
    public void boardTest() {
    	int rows = board.getRows();
    	int columns = board.getColumns();
    	assertTrue(rows==20);
    	assertTrue(columns==10);
    }
    
    @Test
    public void boardZeroTest() {
    	int[][] boardArray = board.getBoard();
    	int[][] zeroArray = new int[20][10];
    	assertTrue(Arrays.deepEquals(zeroArray, boardArray));
    }
    
    @Test
    public void completeLineTest() {
    	for(int i = 0; i < board.getColumns(); i++) {
    		board.setValueToCoord(board.getRows(), i, 1);
    		board.setValueToCoord(board.getRows(), i, 1);
    	}
    	int[][] zeroArray = new int[20][10];
    	assertFalse(Arrays.deepEquals(zeroArray, board.getBoard()));
    	board.eliminateCompleteRows();
    	assertTrue(Arrays.deepEquals(zeroArray, board.getBoard()));
    }
}
