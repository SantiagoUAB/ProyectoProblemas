package ProyectoProblemas;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PieceTest {
	@Test
	public void testCreateShape() {
		int inputType = 4;
		Piece piece = new Piece(inputType);
		int[][] testPiece = {{0,0},{1,0},{1,1},{1,2}};
		int[][] jpiece = piece.getShape();
		int shapeType = piece.getShapeType();
		assertTrue(Arrays.deepEquals(jpiece, testPiece));
		assertTrue(shapeType == inputType);
	}

}
