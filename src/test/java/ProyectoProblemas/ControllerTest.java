package ProyectoProblemas;

import static org.junit.Assert.*;

import java.awt.List;
import java.awt.event.KeyEvent;
import java.util.Arrays;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ControllerTest {
	
	Controller controller;
	ViewInterface view;
	
	@Before
	public void setUp() throws Exception {
		view = new ViewMock();
		controller = new Controller(view);
	}
	
	@Test
	public void generateRandomShapeTest() {
		for (int i=0; i<15; i++) {
			int inputType = controller.proxyGenerateRandomShape();
			assertTrue(inputType>=0 && inputType<=6);
		}
	}
	
	@Test
	public void generateNewPiece() {
		controller.proxyGenerateNewPiece();
		assertTrue(controller.getCurrentX() == 5);
		assertTrue(controller.getCurrentY() == 0);
		assertTrue(controller.getCurrentPiece() != null);
	}
	
	@Test
	public void outofLimitTest() {
		//normal favorable case
		boolean caseA = controller.proxyOutofLimit(0,0);
		assertFalse(caseA);
		
		//negative number case
		boolean caseB = controller.proxyOutofLimit(-9,5);
		assertTrue(caseB);
		
		//frontier case
		boolean caseC = controller.proxyOutofLimit(20,5);
		assertTrue(caseC);
		
		//frontier favorable case
		boolean caseD = controller.proxyOutofLimit(19,5);
		assertFalse(caseD);
		
		//extra test to cover all possible options
		boolean caseE = controller.proxyOutofLimit(4,-21);
		assertTrue(caseE);
		
		//extra test to cover all possible options
		boolean caseF = controller.proxyOutofLimit(4,20);
		assertTrue(caseF);
	}
	
	@Test
	public void fixPieceToBoardTest() {
		//Normal insertion
		int[][] boardArray = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1}
			};
		controller.setCustomBoard(boardArray);
		controller.setCurrentPosition(5,5);
		controller.proxyFixPieceToBoard();
		assertTrue(controller.getBoard()[5][5]!=0);	
		
		//Insertion where some full lines are deleted
		int[][] boardArray2 = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1}
			};
		controller.setCustomBoard(boardArray2);
		controller.setCurrentPosition(5,5);
		controller.proxyFixPieceToBoard();
		assertTrue(controller.getBoard()[6][5]!=0);	
	}
	
	@Test
	public void hardDropTest() {
		//Normal drop
		int[][] boardArray = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1}
			};
		controller.setCustomBoard(boardArray);
		controller.setCurrentPosition(0,5);
		controller.setCurrentPiece(0);
		controller.proxyHardDrop();
		controller.proxyFixPieceToBoard();
		int[][] finalBoard = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,1,0,0,0},
				{0,0,0,0,0,1,1,0,0,0},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1},
				{0,1,1,1,1,1,1,1,1,1}
			};
		assertTrue(Arrays.deepEquals(finalBoard, controller.getBoard()));	
	}
	
	@Test
	public void tryActionTest() {
		int inputType = 4;
		Piece piece = new Piece(inputType);
		
		//doesn't collide vertical move
		boolean caseA = controller.proxyTryAction(piece, 0, 1);
		assertTrue(caseA);
		
		//collides with wall while rotating
		controller.setCurrentPosition(19,9);
		boolean caseB = controller.proxyTryAction(piece.rotateLeft(), 0, 0);
		assertFalse(caseB);
		
		//doesn't collide horizontal move
		controller.setCurrentPosition(10,5);
		boolean caseC = controller.proxyTryAction(piece, 1, 0);
		assertTrue(caseC);
		
		//collides with another block
		int[][] boardArray = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1}
			};
    	controller.setCustomBoard(boardArray);
		controller.setCurrentPosition(10,5);
		boolean caseD = controller.proxyTryAction(piece, 0, 1);
		assertFalse(caseD);
	}
	
	@Ignore
	@Test
	public void mockUserInputs() {
		//KeyEvents setup
		Controller.InputListener b = controller.new InputListener();
		KeyEvent left = new KeyEvent(new List(), KeyEvent.KEY_PRESSED, 20, 1, KeyEvent.VK_LEFT, 'Z');
		KeyEvent right = new KeyEvent(new List(), KeyEvent.KEY_PRESSED, 20, 1, KeyEvent.VK_RIGHT, 'Z');
		KeyEvent z = new KeyEvent(new List(), KeyEvent.KEY_PRESSED, 20, 1, KeyEvent.VK_Z, 'Z');
		KeyEvent x = new KeyEvent(new List(), KeyEvent.KEY_PRESSED, 20, 1, KeyEvent.VK_X, 'Z');
		KeyEvent down = new KeyEvent(new List(), KeyEvent.KEY_PRESSED, 20, 1, KeyEvent.VK_DOWN, 'Z');
		KeyEvent space = new KeyEvent(new List(), KeyEvent.KEY_PRESSED, 20, 1, KeyEvent.VK_SPACE, 'Z');
		
		//valid move case
		controller.setCurrentPosition(5,5);
		controller.setCurrentPiece(5);
		b.keyPressed(left);
		assertTrue(controller.getCurrentX() == 4);
		assertTrue(controller.getCurrentY() == 5);
		
		//valid move case
		b.keyPressed(right);
		assertTrue(controller.getCurrentX() == 5);
		assertTrue(controller.getCurrentY() == 5);
		
		//valid move case
		b.keyPressed(down);
		assertTrue(controller.getCurrentX() == 5);
		assertTrue(controller.getCurrentY() == 6);
		
		//valid move case
		b.keyPressed(space);
		assertTrue(controller.getCurrentX() == 5);
		assertTrue(controller.getCurrentY() == 18);
		
		//valid rotation of piece to left and right
		controller.setCurrentPosition(5,5);
		int[][] beforeTest = controller.getCurrentPiece().getShapeCoordinates();
		b.keyPressed(z);
		b.keyPressed(x);
		assertTrue(Arrays.deepEquals(beforeTest, controller.getCurrentPiece().getShapeCoordinates()));
	}
}
