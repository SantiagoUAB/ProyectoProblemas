package ProyectoProblemas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class View extends JFrame{
	private Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
		setSize(200, 400);
		setTitle("Tetris");
		
		addKeyListener(controller.new InputListener());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

    private int squareWidth() { return (int) getSize().getWidth() / Board.BOARD_COLUMNS; }
    private int squareHeight() { return (int) getSize().getHeight() / Board.BOARD_ROWS; }
    
	public void drawSquare(Graphics g, int x, int y, int shapeType) {
		Color[] colors = {new Color(255,255,255), new Color(255,255,0), new Color(173,216,230), new Color(255,165,0), 
				new Color(255,0,0), new Color(0,0,255), new Color(122,0,0), new Color(110,3, 177)};
		
		g.setColor(colors[shapeType]);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int[][] board = controller.getBoard();
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 10; column++) {
				int shape = board[row][column];
				if(shape != 0) {
					drawSquare(g, column*squareWidth(), row*squareHeight(), shape);
				}
			}
		}
		
		Piece currentPiece = controller.getCurrentPiece();
		for (int i = 0; i < 4; i++) {
			int x = controller.getCurrentX() + currentPiece.getX(i);
			int y = controller.getCurrentY() + currentPiece.getY(i);
			drawSquare(g, x*squareWidth(), y*squareHeight(), currentPiece.getShapeType() + 1);
		}
	}
}
