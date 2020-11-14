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
    public void boardZeroTest() {
    	int[][] boardArray = board.getBoard();
    	int[][] zeroArray = new int[20][10];
    	assertTrue(Arrays.deepEquals(zeroArray, boardArray));
    }
    
    @Test
    public void checkCompleteLineTest() {
    	assertFalse(board.proxyIsLineComplete(Board.BOARD_ROWS-1) == true);
    	
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		board.setValueToCoord(Board.BOARD_ROWS-1, i, 1);
    	}
    	assertTrue(board.proxyIsLineComplete(Board.BOARD_ROWS-1) == true);
    }
    
    @Test
    public void removeLineTest() {
    	// Cas en el que es completa una fila no problematica
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		board.setValueToCoord(Board.BOARD_ROWS-2, i, 1);
    		board.setValueToCoord(Board.BOARD_ROWS-1, i, 2);
    	}
    	board.proxyRemoveLine(Board.BOARD_ROWS-1);
    	int[][] testArray = new int[20][10];
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		testArray[19][i] = 1;
    	}
    	assertTrue(Arrays.deepEquals(testArray, board.getBoard()));
    	
    	
    	// Cas en el que es completa la linea de més amunt (cas límit)
    	board = new Board();
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		board.setValueToCoord(0, i, 1);
    	}
    	board.proxyRemoveLine(0);
    	int[][] testArray1 = new int[20][10];
    	assertTrue(Arrays.deepEquals(testArray1, board.getBoard()));
    }
    
    @Test
    public void removeCompleteLinesTest() {
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		board.setValueToCoord(Board.BOARD_ROWS-2, i, 1);
    		board.setValueToCoord(Board.BOARD_ROWS-1, i, 1);
    	}
    	
    	int[][] zeroArray = new int[20][10];
    	assertFalse(Arrays.deepEquals(zeroArray, board.getBoard()));
    	
    	board.removeCompleteRows();
    	assertTrue(Arrays.deepEquals(zeroArray, board.getBoard()));
    }
    
    @Test
    public void isOccupiedTest() {
    	board.setValueToCoord(0, 1, 4);
    	boolean occupied = board.isOccupied(0, 1);
    	boolean notOccupied = board.isOccupied(0, 2);
    	assertTrue(occupied == true);
    	assertTrue(notOccupied == false);
    }
}
