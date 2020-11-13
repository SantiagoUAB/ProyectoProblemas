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
	
	
}
