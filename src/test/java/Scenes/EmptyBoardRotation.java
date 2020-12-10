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

    int[][] testPiece = {{0,0}, {0,1}, {0,2}, {1,0}};//L-shape
    int[][] assertPiece = piece.getShapeCoordinates();
    int shapeType = piece.getShapeType();
    assertTrue(Arrays.deepEquals(assertPiece, testPiece));
    assertEquals(shapeType, inputType);

    //int[][] emptyBoard = new int[20][10];
    controller.setCustomBoard(board.getBoard());
    controller.setCurrentPosition(4,4);
    controller.setCurrentPiece(piece.getShapeType());
    controller.proxyFixPieceToBoard();

    Piece newPiece = piece.rotateLeft();
    //int[][] coord = newPiece.getShapeCoordinates();
    controller.setCurrentPiece(newPiece);


    controller.getCurrentPiece().rotateLeft();
    controller.proxyFixPieceToBoard();



    /*@Test
	  public void rotateLeftTest() {
		int[][] testPiece = {{0,0},{1, 0},{2, 0},{0, 1}};
		Piece jpiece = piece.rotateLeft();
		int[][] rotatedShape = jpiece.getShapeCoordinates();
		assertTrue(Arrays.deepEquals(rotatedShape, testPiece));

		int[][] testPieceSquare = {{0,0}, {0,1}, {1,1}, {1,0}};
		Piece pieceSqure = new Piece(0);
		Piece rotetedSquare = pieceSqure.rotateLeft();
		int[][] rotatedSquare = rotetedSquare.getShapeCoordinates();
		assertTrue(Arrays.deepEquals(rotatedSquare, testPieceSquare));
	}*/

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
