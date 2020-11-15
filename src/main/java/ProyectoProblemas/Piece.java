package ProyectoProblemas;

/*
 * The Piece class simply stores the information of a shape
 * and it is in charge of doing simple transformations to 
 * the shape.
 */
public class Piece {
	private int[][] shapeCoordinates;
	private int shapeType;
	private static int[][][] shapes = {
			{{0,0}, {0,1}, {1,1}, {1,0}},  //O
			{{0,0}, {0,1}, {0,2}, {0,3}},  //I
			{{0,0}, {0,1}, {0,2}, {1,0}},  //L
			{{0,0}, {0,1}, {1,0}, {-1,1}}, //Z
			{{0,0}, {0,1}, {0,2}, {-1,0}}, //J
			{{0,0}, {0,1}, {1,1}, {-1,1}}, //T
			{{0,0}, {0,1}, {1,1}, {-1,0}}, //S
	};
	
	public Piece(int shapeType) {
		this.shapeType = shapeType;
		shapeCoordinates = shapes[shapeType];
	}
	
	/*
	 * This method is responsible to rotate the piece reverse-clockwise
	 * using an rotation algorithm only if the piece isn't a Square
	 */
	public Piece rotateLeft() {
		if(shapeType == 0) {
			return this;
		}
		Piece newPiece = new Piece(shapeType);
		int[][] newShape = new int[4][2];
		for (int a=0; a<4; a++) {
			newShape[a][0] = shapeCoordinates[a][1];
			newShape[a][1] = -shapeCoordinates[a][0];
		}
		newPiece.shapeCoordinates = newShape;
		return newPiece;
	}
	
	/*
	 * This method is responsible to rotate the piece clockwise
	 * using an rotation algorithm only if the piece isn't a Square
	 */
	public Piece rotateRight() {
		if(shapeType == 0) {
			return this;
		}
		Piece newPiece = new Piece(shapeType);
		int[][] newShape = new int[4][2];
		for (int a=0; a<4; a++) {
			newShape[a][0] = -shapeCoordinates[a][1];
			newShape[a][1] = shapeCoordinates[a][0];
		}
		newPiece.shapeCoordinates = newShape;
		return newPiece;
	}
	
	public int[][] getShapeCoordinates() {
		return shapeCoordinates;
	}
	
	public int getShapeType() {
		return shapeType;
	}
	
	public int getX(int block) {
		return shapeCoordinates[block][0];
	}
	
	public int getY(int block) {
		return shapeCoordinates[block][1];
	}
}
