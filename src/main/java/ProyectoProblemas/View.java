package ProyectoProblemas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ProyectoProblemas.Controller.InputListener;

public class View extends JFrame implements ViewInterface {
	private int currentX;
	private int currentY;
	private Piece currentPiece;
	private int[][] board;
	
	public View() {
		setSize(200, 400);
		setTitle("Tetris");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setKeyListener(InputListener inputListener) {
		addKeyListener(inputListener);
	}
	
    public int squareWidth() { return (int) getSize().getWidth() / Board.BOARD_COLUMNS; }
    public int squareHeight() { return (int) getSize().getHeight() / Board.BOARD_ROWS; }
    
	public void drawSquare(Graphics g, int x, int y, int shapeType) {
		Color[] colors = {new Color(255,255,255), new Color(255,255,0), new Color(173,216,230), new Color(255,165,0), 
				new Color(255,0,0), new Color(0,0,255), new Color(122,0,0), new Color(110,3, 177)};
		
		g.setColor(colors[shapeType]);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
	}
	
	public void arguments(int currentX, int currentY, int[][] board, Piece currentPiece) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.board = board;
		this.currentPiece = currentPiece;
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 10; column++) {
				int shape = board[row][column];
				if(shape != 0) {
					drawSquare(g, column*squareWidth(), row*squareHeight(), shape);
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			int x = currentX + currentPiece.getX(i);
			int y = currentY + currentPiece.getY(i);
			drawSquare(g, x*squareWidth(), y*squareHeight(), currentPiece.getShapeType() + 1);
		}
	}
}
