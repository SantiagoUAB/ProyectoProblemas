package Scenes;

import ProyectoProblemas.Controller;
import ProyectoProblemas.Piece;
import ProyectoProblemas.View;
import ProyectoProblemas.ViewInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MoveShapes {
    Piece piece;
    int shapeType;
    Controller controller ;

    @BeforeEach
    public void setUp(){
        shapeType = 0; // O
        piece = new Piece(shapeType);

        ViewInterface view = new View();
        controller = new Controller(view);
    }

    @Test
    public void moveRightOutBoard(){
        int moveRight20 = 20;
        int auxCurrentX = controller.getCurrentX();
        int auxCurrentY = controller.getCurrentY();
        assertFalse(this.controller.proxyTryAction(piece, moveRight20, 0));
        assertEquals(auxCurrentX,controller.getCurrentX());
        assertEquals(auxCurrentY,controller.getCurrentY());
    }

    @Test
    public void moveRightInBoard(){
        int moveRight ;
        for (int i = 0; i < 3; i++) {
            moveRight = i;
            int auxCurrentX = controller.getCurrentX();
            int auxCurrentY = controller.getCurrentY();
            assertTrue(this.controller.proxyTryAction(piece, moveRight, 0));
            assertEquals(auxCurrentX+moveRight,controller.getCurrentX());
            assertEquals(auxCurrentY,controller.getCurrentY());
        }
    }

    @Test
    public void moveLeftOutBoard(){
        int moveLeft20 = -20;
        int auxCurrentX = controller.getCurrentX();
        int auxCurrentY = controller.getCurrentY();
        assertFalse(this.controller.proxyTryAction(piece, moveLeft20, 0));
        assertEquals(auxCurrentX,controller.getCurrentX());
        assertEquals(auxCurrentY,controller.getCurrentY());
    }

    @Test
    public void moveLeftInBoard(){
        int moveLeft;
        for (int i = 0; i < 3; i++) {
            moveLeft = -i;
            int auxCurrentX = controller.getCurrentX();
            int auxCurrentY = controller.getCurrentY();
            assertTrue(this.controller.proxyTryAction(piece, moveLeft, 0));
            assertEquals(auxCurrentX+moveLeft,controller.getCurrentX());
            assertEquals(auxCurrentY,controller.getCurrentY());
        }
    }

}
