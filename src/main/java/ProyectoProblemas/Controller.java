package ProyectoProblemas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*
 * The class Controller is responsible to
 * 
 */
public class Controller {
	
	private Piece currentPiece;
	private Board board;
	private ViewInterface view;
	private Timer timer;
	/*
	 * currentX and currentY are used to
	 * simulate a pointer in the board to
	 * where the currentPiece will be. 
	 * The piece coordinates in the board
	 * are calculated using this values.
	 */
	private int currentX;
	private int currentY;
	
	public Controller(ViewInterface view) {
		board = new Board();
		timer = new Timer();
		this.view = view;
		view.setKeyListener(new InputListener());
		generateNewPiece();

	}
	
	/*
	 * This method creates two repeatable tasks and
	 * schedules them. One of them contains the game flow
	 * and the other one the screen updates.
	 */
	public void startGame() {
		TimerTask gameFlow = new TimerTask() {
			public void run() {
				if(!softDrop()) {
					fixPieceToBoard();
					generateNewPiece();
					gameOver();
				}
			}
		};
		TimerTask screenUpdate = new TimerTask() {
			public void run() {
				((View) view).arguments(currentX, currentY, board.getBoard(), currentPiece);
			}
		};
		//300 ms to lower the difficulty
		timer.scheduleAtFixedRate(gameFlow, 0, 300);
		//40 ms to get 25 fps
		timer.scheduleAtFixedRate(screenUpdate, 0, 300);
	}
	
	/*
	 * This method checks if the piece can get one line down
	 * and if not the game finishes.
	 */
	private void gameOver() {
		if(!softDrop()) {
			timer.cancel();
		}
	}
	
	/*
	 * This method checks if an action is applicable to a piece,
	 * if its possible the sate of the piece is saved.
	 */
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
	
	/*
	 * This method generates a new random piece and sets 
	 * the initial location to the center of the board.
	 */
	private void generateNewPiece() {
		/*Test equipment: Modified function, instead of generating the pieces randomly
		they are generated in order.*/

		if (currentPiece == null){
			currentPiece =  new Piece(0);
		}
		else if(currentPiece.getShapeType()+1 > 6){
			currentPiece =  new Piece(0);
		}else{
			currentPiece =  new Piece(currentPiece.getShapeType()+1);
		}
		currentX = Board.BOARD_COLUMNS / 2;
		currentY = 0;
	}

	private Piece generateNewPieceOrder() {

		if(currentPiece.getShapeType()+1 > 6 || currentPiece == null){
			return  new Piece(0);
		}else{
			return  new Piece(currentPiece.getShapeType()+1);
		}

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
	
	/*
	 * This method is used to directly drop a piece
	 * unit it touches the ground or another piece.
	 */
	private void hardDrop() {
		while(softDrop());
	}
	
	/*
	 * Friend class of Controller that has only one method
	 * that gets triggered when some key is pressed by the
	 * user.
	 * The class is inside Controller because it has to use
	 * private methods to execute the actions.
	 */
	public class InputListener extends KeyAdapter {
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
	
	/*
	 * This method is responsible to fix curretPiece to
	 * the board when it's called and calls the function
	 * removeCompleteRows to check if some row has been
	 * completed.
	 */
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
	
	public void proxyHardDrop() {
		hardDrop();
	}
	
	public int[][] getBoard() {
		return board.getBoard();
	}	
	
	public void proxyFixPieceToBoard() {
		fixPieceToBoard();
	}

	//PROXYS CREADOS PARA TESTING PARTE 2
	public void proxyRotateLeft(){
		rotateLeft();
	}

	public void proxyRotateRight(){
		moveRight();
	}

	public void proxySetValueCoord(int row, int col, int type){board.setValueToCoord(row, col, type);}

	public boolean proxyGetsoftDrop() {return softDrop();};
}
