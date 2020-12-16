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
	
	/*
	 * Asserts board is initialized to 0.
	 */
    @Test
    public void boardZeroTest() {
    	int[][] boardArray = board.getBoard();
    	int[][] zeroArray = new int[20][10];
    	assertTrue(Arrays.deepEquals(zeroArray, boardArray));
    }
    
    /*
	 * Checks in a clear board if the line is complete.
	 * Then fills the line and asserts the line is now complete.
	 */
    @Test
    public void checkCompleteLineTest() {
    	assertFalse(board.proxyIsLineComplete(Board.BOARD_ROWS-1));
    	
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		board.setValueToCoord(Board.BOARD_ROWS-1, i, 1);
    	}
    	assertTrue(board.proxyIsLineComplete(Board.BOARD_ROWS-1));
    }
    
    /*
	 * Creates a mock board with some pieces and removes them.
	 * Checks the two possible cases.
	 */    
    @Test
    public void removeLineTest() {
    	//Normal row test case
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
    		
    	//Top row test case
    	board = new Board();
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		board.setValueToCoord(0, i, 1);
    	}
    	board.proxyRemoveLine(0);
    	int[][] testArray1 = new int[20][10];
    	assertTrue(Arrays.deepEquals(testArray1, board.getBoard()));
    }
    
    /*
	 * Creates a mock board with some full rows and removes them.
	 * Asserts the board is now empty and executes the function
	 * again to check for errors.
	 */  
    @Test
    public void removeCompleteLinesTest() {
    	for(int i = 0; i < Board.BOARD_COLUMNS; i++) {
    		board.setValueToCoord(Board.BOARD_ROWS-2, i, 1);
    		board.setValueToCoord(Board.BOARD_ROWS-1, i, 1);
    	}
    	//Test with 2 completed rows
    	int[][] zeroArray = new int[20][10];
    	assertFalse(Arrays.deepEquals(zeroArray, board.getBoard()));
    	
    	//Test without any completed row
    	board.removeCompleteRows();
    	assertTrue(Arrays.deepEquals(zeroArray, board.getBoard()));
    }
    
    /*
	 * Creates a mock board with only a block.
	 * Asserts the block position is occupied and one other
	 * position is free.
	 */ 
    @Test
    public void isOccupiedTest() {
    	board.setValueToCoord(0, 1, 4);
    	boolean occupied = board.isOccupied(0, 1);
    	boolean notOccupied = board.isOccupied(0, 2);
    	assertTrue(occupied == true);
    	assertTrue(notOccupied == false);

    }
    
    /*
   	 * Uses mock boards to assure its reliability in some scenarios.
   	 */ 
    @Test
    public void loopTestIsLineComplete() {
    	
    	//Make 0 passes through the loop
    	int[][] mockBoard = {{0, 0, 0, 0}};
    	board.setCustomBoard(mockBoard);
    	assertFalse(board.proxyIsLineComplete(0));
    	
    	//Make 1 passes through the loop
    	int[][] mockBoard1 = {{1, 0, 0, 0}};
    	board.setCustomBoard(mockBoard1);
    	board.proxyIsLineComplete(0);
    	assertFalse(board.proxyIsLineComplete(0));
    	
    	//Make Max-1 passes through the loop
    	int[][] mockBoard2 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    	board.setCustomBoard(mockBoard2);
    	board.proxyIsLineComplete(0);
    	assertTrue(board.proxyIsLineComplete(0));
    	
    	//Make Max passes through the loop
    	int[][] mockBoard3 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    	board.setCustomBoard(mockBoard3);
    	board.proxyIsLineComplete(0);
    	assertTrue(board.proxyIsLineComplete(0));
    	
    	//Make Max+1 passes through the loop
    	int[][] mockBoard4 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    	board.setCustomBoard(mockBoard4);
    	board.proxyIsLineComplete(0);
    	assertTrue(board.proxyIsLineComplete(0));
    }
}
