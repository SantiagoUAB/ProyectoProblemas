package ProyectoProblemas;

public class Piece {
	private int[][] shape;
	private int shapeType;
	private static int[][][] shapes = {
			{{0,0}, {0,1}, {1,1}, {1,0}},  //O
			{{0,0}, {0,1}, {0,2}, {0,3}},  //I
			{{0,0}, {0,1}, {0,2}, {1,0}},  //L
			{{-1,1}, {0,1}, {0,0}, {1,0}}, //Z
			{{0,0}, {1,0}, {1,1}, {1,2}},  //J
			{{0,0}, {-1,1}, {0,1}, {1,1}}, //T
			{{0,0}, {1,0}, {1,1}, {2,1}},  //S
	};
	
	public Piece(int shapeType) {
		this.shapeType = shapeType;
		shape = shapes[shapeType];
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
	
	public Piece rotateLeft() {
		Piece newPiece = new Piece(shapeType);
		int[][] newShape = new int[4][2];
		for (int a=0; a<4; a++) {
			newShape[a][0] = shape[a][1];			//x = (y)
			newShape[a][1] = -shape[a][0];			//y = (-x)
		}
		newPiece.shape = newShape;
		return newPiece;
	}
	
	public Piece rotateRight() {
		Piece newPiece = new Piece(shapeType);
		int[][] newShape = new int[4][2];
		for (int a=0; a<4; a++) {
			newShape[a][0] = -shape[a][1];			//x = (y)
			newShape[a][1] = shape[a][0];			//y = (-x)
		}
		newPiece.shape = newShape;
		return newPiece;
	}
}
