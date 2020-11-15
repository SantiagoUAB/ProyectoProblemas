package ProyectoProblemas;

public class Board {
	static final int BOARD_ROWS = 20;
	static final int BOARD_COLUMNS = 10;
	private int[][] board;
	
	
	public Board() {
		board = new int[BOARD_ROWS][BOARD_COLUMNS];
	}
	
	public boolean isOccupied(int row, int column) {
		return board[row][column] != 0;
	}
	
	public void setValueToCoord(int row, int column, int value) {
		board[row][column] = value;
	}
	
	/*
	 * This method checks if the row passed in the argument 
	 * has any 0 in it, which means it's not complete.
	 */
	private boolean isLineComplete(int row) {
		int column = 0;
		while(column < BOARD_COLUMNS && board[row][column] != 0) {
			column++;
		}
		if(column==BOARD_COLUMNS) column--;
		return board[row][column] != 0;
	}
	
	/*
	 * This method removes the line passed by argument,
	 * which means make the ones above it get one row down
	 * if the specified rows isn't the one at the top at all.
	 */
	private void removeLine(int row) {
		if(row == 0) {
			for(int column = 0; column < BOARD_COLUMNS; column++) {
				board[row][column] = 0;
			}
		} else {
			for(int actualRow = row; actualRow > 0; actualRow--) {
				for(int column = 0; column < BOARD_COLUMNS; column++) {
					board[actualRow][column] = board[actualRow - 1][column];
				}
			}
		}
	}
	
	/*
	 * This method removes the line passed by argument,
	 * which means make the ones above it get one row down
	 * if the specified rows isn't the one at the top at all.
	 */
	public void removeCompleteRows() {
		for(int row = 0; row < BOARD_ROWS; row++) {
			if(isLineComplete(row)) {
				removeLine(row);
			}
		}
	}

	public int[][] getBoard(){
		return board;
	}

	//FUNCTIONS ONLY NEEDED FOR TESTING
	
	public boolean proxyIsLineComplete(int row) {
		return isLineComplete(row);
	}
	
	public void proxyRemoveLine(int row) {
		removeLine(row);
	}
	
	public void setCustomBoard(int[][] boardArray) {
		board = boardArray;
	}
}
