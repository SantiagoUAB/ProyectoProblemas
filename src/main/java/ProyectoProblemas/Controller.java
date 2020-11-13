package ProyectoProblemas;

public class Controller {
	
	private Board board;
	
	public Controller() {
		board = new Board();
	}
	
	private boolean outofLimit(int row, int column) {
		return (column<0 || column >= board.getColumns() || row<0 || row>= board.getRows());
	}

	public boolean proxyOutofLimit(int row, int column) {
		return outofLimit(row, column);
	}

}