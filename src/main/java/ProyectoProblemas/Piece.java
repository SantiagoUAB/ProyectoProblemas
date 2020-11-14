package ProyectoProblemas;

public class Piece {
	private int[][] shape;
	private int shapeType;
	private static int[][][] shapes = {
			{{0,0}, {0,1}, {1,1}, {1,0}},  //O
			{{0,0}, {0,1}, {0,2}, {0,3}},  //I
			{{0,0}, {0,1}, {0,2}, {1,0}},  //L
			{{0,0}, {0,1}, {1,0}, {-1,1}}, //Z
			{{0,0}, {0,1}, {0,2}, {-1,0}}, //J
			{{0,0}, {0,1}, {1,1}, {-1,1}}, //T
			{{0,0}, {0,1}, {1,1}, {-1,0}},  //S
	};
	
	public Piece(int shapeType) {
		this.shapeType = shapeType;
		shape = shapes[shapeType];
	}
	
	
	public Piece rotateLeft() {
		if(shapeType == 0) {
			return this;
		}
		Piece newPiece = new Piece(shapeType);
		int[][] newShape = new int[4][2];
		for (int a=0; a<4; a++) {
			newShape[a][0] = shape[a][1];
			newShape[a][1] = -shape[a][0];
		}
		newPiece.shape = newShape;
		return newPiece;
	}
	
	public Piece rotateRight() {
		if(shapeType == 0) {
			return this;
		}
		Piece newPiece = new Piece(shapeType);
		int[][] newShape = new int[4][2];
		for (int a=0; a<4; a++) {
			newShape[a][0] = -shape[a][1];
			newShape[a][1] = shape[a][0];
		}
		newPiece.shape = newShape;
		return newPiece;
	}
	
	public int[][] getShape() {
		return shape;
	}
	
	public int getShapeType() {
		return shapeType;
	}
	
	public int getX(int block) {
		return shape[block][0];
	}
	
	public int getY(int block) {
		return shape[block][1];
	}
}
