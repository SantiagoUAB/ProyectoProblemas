package ProyectoProblemas;

public class Controller {
	
	private Board board;
	private Piece currentPiece;
	private int currentX;
	private int currentY;
	
	public Controller() {
		board = new Board();
		currentX = 0;
		currentY = 0;
	}
	
	@SuppressWarnings("unused")
	private boolean tryAction(Piece newPiece, int moveX, int moveY) {
		
		for (int i=0; i<4; i++) {
			int newColumn = newPiece.getX(i) + moveX + currentX;
			int newRow = newPiece.getY(i) + moveY + currentY;
			if (board.isOccupied(newRow, newColumn)) {
				return false;
			}
			if (outofLimit(newRow, newColumn)) {
				return false;
			}
		}
		currentPiece = newPiece;
		currentX += moveX;
		currentY += moveY;
		return true;
	}
	
	private boolean outofLimit(int row, int column) {
		return (column<0 || column >= board.getColumns() || row<0 || row>= board.getRows());
	}

	public boolean proxyOutofLimit(int row, int column) {
		return outofLimit(row, column);
	}

}