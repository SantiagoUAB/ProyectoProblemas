package Mock;

import ProyectoProblemas.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MockEndGame {
    Controller controller;
    ViewInterface view;

    @Before
    public void setUp() throws Exception {
        view = new ViewMock();
        controller = new Controller(view);
    }

    @Test
    public void MockEndGame(){
        int x, y;
        x = 0;
        y = 5 ;

        for (int typeShape  = 0; typeShape < 7; typeShape++) {
            int[][] boardArray = getBoardPerso();

            controller.setCustomBoard(boardArray);
            controller.setCurrentPiece(typeShape);
            controller.setCurrentPosition(x,y);
            controller.proxyFixPieceToBoard();

            assertTrue(!controller.proxyGetsoftDrop()); // determina sie le juego finaliza
            assertFalse(controller.proxyGetsoftDrop()); // determina sie le juego finaliza
            printBoard(typeShape);
        }
    }


    private int[][] getBoardPerso() {
        int[][] boardArray = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1}
        };
        return boardArray;
    }

    private void printBoard(int type ) {
        System.out.println("\n----------------------------------------");
        System.out.println("\n------ TypeShape " + (type+1) + " -----------------");
        System.out.println("\n----------------------------------------");
        for (int x = 0; x < controller.getBoard().length; x++){
            for (int y=0; y < controller.getBoard()[x].length; y++)
                System.out.print(" | " + controller.getBoard()[x][y]+ " | ");
            System.out.println("\n---------------------------------------------------------------------");

        }



    }
}
