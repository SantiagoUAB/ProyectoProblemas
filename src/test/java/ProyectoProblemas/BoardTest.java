package ProyectoProblemas;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class BoardTest {
	
    @Test
    public void boardTest() {
    	Board board = new Board();
    	int rows = board.getRows();
    	int columns = board.getColumns();
    	assertTrue(rows==20);
    	assertTrue(columns==10);
    }
    
}
