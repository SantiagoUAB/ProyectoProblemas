package ProyectoProblemas;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PieceTest {
	Piece piece;
	int inputType;
	
	@Before
	public void setUp() throws Exception{
		inputType = 4;
		piece = new Piece(inputType);
	}
	
	/*
	 * Creates a J-shaped piece and asserts its coordinates
	 * and inputType are correct. 	  
	 */ 
	@Test
	public void createShapeTest() {		
		int[][] testPiece = {{0,0}, {0,1}, {0,2}, {-1,0}};
		int[][] jpiece = piece.getShapeCoordinates();
		int shapeType = piece.getShapeType();
		assertTrue(Arrays.deepEquals(jpiece, testPiece));
		assertTrue(shapeType == inputType);
	}
	
	/*
	 * Creates a J-shaped piece and asserts its coordinates
	 * are correct after rotating it to the left. 	  
	 */ 
	@Test
	public void rotateLeftTest() {
		int[][] testPiece = {{0,0},{1, 0},{2, 0},{0, 1}};
		Piece jpiece = piece.rotateLeft();
		int[][] rotatedShape = jpiece.getShapeCoordinates();
		assertTrue(Arrays.deepEquals(rotatedShape, testPiece));
		
		int[][] testPieceSquare = {{0,0}, {0,1}, {1,1}, {1,0}};
		Piece pieceSqure = new Piece(0);
		Piece rotetedSquare = pieceSqure.rotateLeft();
		int[][] rotatedSquare = rotetedSquare.getShapeCoordinates();
		assertTrue(Arrays.deepEquals(rotatedSquare, testPieceSquare));
	}
	
	/*
	 * Creates a J-shaped piece and asserts its coordinates
	 * are correct after rotating it to the right.
	 * Asserts the same with a square-shaped piece. 	  
	 */ 
	@Test
	public void rotateRightTest() {
		int[][] testPiece = {{0,0},{-1, 0},{-2, 0},{0, -1}};
		Piece jpiece = piece.rotateRight();
		int[][] rotatedShape = jpiece.getShapeCoordinates();
		assertTrue(Arrays.deepEquals(rotatedShape, testPiece));
		
		
		int[][] testPieceSquare = {{0,0}, {0,1}, {1,1}, {1,0}};
		Piece pieceSqure = new Piece(0);
		Piece rotetedSquare = pieceSqure.rotateRight();
		int[][] rotatedSquare = rotetedSquare.getShapeCoordinates();
		assertTrue(Arrays.deepEquals(rotatedSquare, testPieceSquare));
	}
}
