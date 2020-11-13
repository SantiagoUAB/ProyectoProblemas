package ProyectoProblemas;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PieceTest {

	@Test
	public void testCreateShape() {
		Piece piece = new Piece('j');
		int[][] testPiece = {{0,0},{1,0},{1,1},{1,2}};
		int[][] jpiece = piece.getShape();
		assertTrue(Arrays.deepEquals(jpiece, testPiece));
	}

}
