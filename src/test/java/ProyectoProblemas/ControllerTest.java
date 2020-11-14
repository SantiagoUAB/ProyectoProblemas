package ProyectoProblemas;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	
	Controller controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new Controller();
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
	}
	
	@Test
	public void moveLeftTest() {
		controller.setCurrentPosition(5, 5);
		controller.proxyMoveLeft();
		assertTrue(controller.getCurrentX()==4);
		assertTrue(controller.getCurrentY()==5);
	}
	
	@Test
	public void moveRightTest() {
		controller.setCurrentPosition(5, 5);
		controller.proxyMoveRight();
		assertTrue(controller.getCurrentX()==6);
		assertTrue(controller.getCurrentY()==5);
	}
	
	@Test
	public void softDropTest() {
		controller.setCurrentPosition(5, 5);
		controller.proxySoftDrop();
		assertTrue(controller.getCurrentY()==6);
		assertTrue(controller.getCurrentX()==5);
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
}
