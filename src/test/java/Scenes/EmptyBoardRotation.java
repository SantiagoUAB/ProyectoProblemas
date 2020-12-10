package Scenes;

import ProyectoProblemas.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmptyBoardRotation {

  Piece piece;
  int inputType;
  Board board;
  Controller controller;
  ViewInterface view;

  @Before
  public void setUp(){
    board = new Board();
    view = new ViewMock();
    controller = new Controller(view);
    inputType = 2;
    piece = new Piece(inputType);
  }

  /*
   * Creates a L-shaped piece and asserts it can rotates
   * in the middle of the board.
   */

  @Test
  public void rotatesPieceMiddleBoard(){

    controller.setCustomBoard(board.getBoard());
    controller.setCurrentPosition(4,4);
    controller.setCurrentPiece(piece.getShapeType());
    controller.proxyFixPieceToBoard();
    controller.proxyRotateLeft();
    controller.proxyFixPieceToBoard();

    int[][] boardAfterRotation = {
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
    };

    assertTrue(Arrays.deepEquals(board.getBoard(), boardAfterRotation));


  }

}
