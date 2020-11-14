package ProyectoProblemas;

public class TetrisGame {
	public static void main(String[] args) {
		ViewInterface view = new View();
		Controller controller = new Controller(view);
		controller.startGame();
	}
}
