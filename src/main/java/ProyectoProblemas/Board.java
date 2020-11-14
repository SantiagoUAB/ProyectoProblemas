package ProyectoProblemas;

public class Board {
	private final int boardRows = 20;
	private final int boardColumns = 10;
	private int[][] board;
	
	
	public Board() {
		board = new int[boardRows][boardColumns];
	}
	
	public boolean isOccupied(int row, int column) {
		return board[row][column] != 0;
	}
	
	public void setValueToCoord(int row, int column, int value) {
		board[row][column] = value;
	}
	
	private boolean isLineComplete(int row) {
		boolean complete = true;
		int column = 0;
		while(column < boardColumns && complete) {
			if(board[row][column] == 0) {
				complete = false;
			}
			column++;
		}
		return complete;
	}	
	
	private void removeLine(int row) {
		if(row == 0) {
			for(int column = 0; column < boardColumns; column++) {
				board[row][column] = 0;
			}
		} else {
			for(int actualRow = row; actualRow > 0; actualRow--) {
				for(int column = 0; column < boardColumns; column++) {
					board[actualRow][column] = board[actualRow - 1][column];
				}
			}
		}
	}

	public void removeCompleteRows() {
		for(int row = 0; row < boardRows; row++) {
			if(isLineComplete(row)) {
				removeLine(row);
			}
		}
	}
	
	public int getRows() {
		return boardRows;
	}
	
	public int getColumns() {
		return boardColumns;
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
