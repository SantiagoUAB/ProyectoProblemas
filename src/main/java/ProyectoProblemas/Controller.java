package ProyectoProblemas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
	
	private Piece currentPiece;
	private Board board;
	private Timer timer;
	private int currentX;
	private int currentY;
	
	public Controller() {
		board = new Board();
		generateNewPiece();
		timer = new Timer();
	}

	public void startGame() {
		View view = new View(this);
		TimerTask repeatedTask = new TimerTask() {
			public void run() {
				if(!softDrop()) {
					fixPieceToBoard();
					generateNewPiece();
					isGameOver();

				}
				view.repaint();
			}
		};
		timer.scheduleAtFixedRate(repeatedTask, 0, 200);
	}

	private void isGameOver() {
		if(!softDrop()) {
			timer.cancel();
		}
	}
	
	private boolean tryAction(Piece newPiece, int moveX, int moveY) {	
		for (int i=0; i<4; i++) {
			int newColumn = newPiece.getX(i) + moveX + currentX;
			int newRow = newPiece.getY(i) + moveY + currentY;
			if (outofLimit(newRow, newColumn)||board.isOccupied(newRow, newColumn)) {
				return false;
			}
		}
		currentPiece = newPiece;
		currentX += moveX;
		currentY += moveY;
		return true;
	}
	
	private boolean outofLimit(int row, int column) {
		return (column<0 || column >= Board.BOARD_COLUMNS || row<0 || row>= Board.BOARD_ROWS);
	}
	
	private int generateRandomShape() {
		Random rand = new Random();
		int res = Math.abs(rand.nextInt()) % 7;
		return res;
	}
	
	private void generateNewPiece() {
		currentPiece = new Piece(generateRandomShape());
		currentX = Board.BOARD_COLUMNS / 2;
		currentY = 0;
	}

	private void moveLeft() {
		tryAction(currentPiece, -1, 0);
	}
	
	private void moveRight() {
		tryAction(currentPiece, +1, 0);
	}
	
	private void rotateLeft() {
		tryAction(currentPiece.rotateLeft(), 0, 0);
	}
	
	private void rotateRight() {
		tryAction(currentPiece.rotateRight(), 0, 0);
	}
	
	private boolean softDrop() {
		return tryAction(currentPiece, 0, +1);
	}
	
	private void hardDrop() {
		while(softDrop());
		fixPieceToBoard();
	}

	class InputListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			switch (key) {
				case KeyEvent.VK_Z:
					rotateLeft();
					break;
				case KeyEvent.VK_X:
					rotateRight();
					break;
				case KeyEvent.VK_LEFT:
					moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					moveRight();
					break;
				case KeyEvent.VK_DOWN:
					softDrop();
					break;
				case KeyEvent.VK_SPACE:
					hardDrop();
					break;
			}
		}
	}
	
	private void fixPieceToBoard() {
		for (int i = 0; i < 4; i++) {
			int newColumn = currentPiece.getX(i) + currentX;
			int newRow = currentPiece.getY(i) + currentY;
			board.setValueToCoord(newRow, newColumn, currentPiece.getShapeType() + 1);
		}
		board.removeCompleteRows();
	}
	
	//FUNCTIONS ONLY NEEDED FOR TESTING
	
	public boolean proxyOutofLimit(int row, int column) {
		return outofLimit(row, column);
	}
	
	public boolean proxyTryAction(Piece newPiece, int moveX, int moveY) {
		return tryAction(newPiece, moveX, moveY);
	}
	
	public void setCurrentPosition(int row, int column) {
		currentX = column;
		currentY = row;
	}
	
	public void setCurrentPiece(int shapeType) {
		currentPiece = new Piece(shapeType);
	}
	
	public int getCurrentX() {
		return(currentX);
	}
	
	public int getCurrentY() {
		return currentY;
	}
	
	public void setCustomBoard(int[][] boardArray) {
		board.setCustomBoard(boardArray);
	}
	
	public int proxyGenerateRandomShape(){
		return generateRandomShape();
	}
	
	public void proxyGenerateNewPiece() {
		generateNewPiece();
	}
	
	public Piece getCurrentPiece() {
		return currentPiece;
	}
	
	public void proxyMoveLeft() {
		moveLeft();
	}
	
	public void proxyMoveRight() {
		moveRight();
	}
	
	public void proxyRotateLeft() {
		rotateLeft();
	}
	
	public void proxyRotateRight() {
		rotateRight();
	}
	
	public void proxySoftDrop() {
		softDrop();
	}
	
	public void proxyHardDrop() {
		hardDrop();
	}
	
	public int[][] getBoard() {
		return board.getBoard();
	}	
	
	public void proxyFixPieceToBoard() {
		fixPieceToBoard();
	}
}
