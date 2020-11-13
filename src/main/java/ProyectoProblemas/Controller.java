package ProyectoProblemas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Controller {
	
	private Piece currentPiece;
	private Board board;
	private int currentX;
	private int currentY;
	
	public Controller() {
		currentPiece = new Piece(generateRandomShape());
		board = new Board();
		currentX = 0;
		currentY = 0;
	}

	public void startGame() {
		
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
		return (column<0 || column >= board.getColumns() || row<0 || row>= board.getRows());
	}
	
	private int generateRandomShape() {
		Random rand = new Random();
		int res = Math.abs(rand.nextInt()) % 6 + 1;
		return res;
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
	
	private class InputListener extends KeyAdapter {
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
					//softDrop();
					break;
				case KeyEvent.VK_SPACE:
					//hardDrop();
					break;
			}
		}
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
	
	public int getCurrentX() {
		return(currentX);
	}
	
	public void setCustomBoard(int[][] boardArray) {
		board.setCustomBoard(boardArray);
	}
	
	public int proxyGenerateRandomShape(){
		return generateRandomShape();
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
	
	
}