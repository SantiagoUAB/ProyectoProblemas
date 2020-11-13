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
	
	@Test
	public void testCreateShape() {		
		int[][] testPiece = {{0,0},{1,0},{1,1},{1,2}};
		int[][] jpiece = piece.getShape();
		int shapeType = piece.getShapeType();
		assertTrue(Arrays.deepEquals(jpiece, testPiece));
		assertTrue(shapeType == inputType);
	}
	
	@Test
	public void testRotateShape() {
		int[][] testPiece = {{0,0},{0,-1},{1,-1},{2,-1}};
		piece.rotateShape();
		int[][] jpiece = piece.getShape();
		for (int a=0; a<4; a++) {
			System.out.println(Arrays.toString(jpiece[a]));
		}
		assertTrue(Arrays.deepEquals(jpiece, testPiece));
	}

}
