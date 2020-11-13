package ProyectoProblemas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	
	Controller controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new Controller();
	}
	
	@Test
	public void outofLimitTest() {
		boolean caseA = controller.proxyOutofLimit(0,0);
		boolean caseB = controller.proxyOutofLimit(-10,14);
		assertFalse(caseA);
		assertTrue(caseB);
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
	
	@Test
	public void generateRandomShapeTest() {
		for (int i=0; i<15; i++) {
			int inputType = controller.proxyGenerateRandomShape();
			assertTrue(inputType>=0 && inputType<=6);
		}
	}
}
