package ProyectoProblemas;

public class Board {
	private final int boardRows = 20;
	private final int boardColumns = 10;
	private final int[][] board;
	
	
	public Board() {
		board = new int[boardRows][boardColumns];
	}
	
	public int getRows() {
		return boardRows;
	}
	
	public int getColumns() {
		return boardColumns;
	}
	
}
