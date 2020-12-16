package Scenes;

import ProyectoProblemas.Board;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoardOccupied {

    @Test
    public void estaOcupado(){

        Board board = new Board();
        int x, y, type;
        x = 0;
        y = 0;
        type = 1;
        board.setValueToCoord(x,y,type);
        assertTrue(board.isOccupied(x,y));

        x = 1;
        y = 1;
        type = 1;
        board.setValueToCoord(x,y,type);
        assertTrue(board.isOccupied(x,y));

        x = 5;
        y = 5;
        type = 6;
        board.setValueToCoord(x,y,type);
        assertTrue(board.isOccupied(x,y));

        x = 2;
        y = 2;
        type = 2;
        board.setValueToCoord(x,y,type);
        assertTrue(board.isOccupied(x,y));

    }
}
