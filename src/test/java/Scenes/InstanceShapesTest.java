package Scenes;

import ProyectoProblemas.Piece;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;


public class InstanceShapesTest {
    Piece piece;
    int shapeType;


    @Test
    public  void createShapeO(){
        shapeType = 0;
        piece = new Piece(shapeType);
        int[][] testShape0 = {{0,0}, {0,1}, {1,1}, {1,0}};
        int[][] shapeO = piece.getShapeCoordinates();
        assertTrue(Arrays.deepEquals(shapeO, testShape0));
    }

    @Test
    public  void createShapeI(){
        shapeType = 1;
        piece = new Piece(shapeType);
        int[][] testShapeI = {{0,0}, {0,1}, {0,2}, {0,3}} ;
        int[][] shapeI = piece.getShapeCoordinates();
        assertTrue(Arrays.deepEquals(shapeI, testShapeI));
    }

    @Test
    public  void createShapeL(){
        shapeType = 2;
        piece = new Piece(shapeType);
        int[][] testShapeL = {{0,0}, {0,1}, {0,2}, {1,0}} ;
        int[][] shapeL = piece.getShapeCoordinates();
        assertTrue(Arrays.deepEquals(shapeL, testShapeL));
    }

    @Test
    public  void createShapeZ(){
        shapeType = 3;
        piece = new Piece(shapeType);
        int[][] testShapeZ = {{0,0}, {0,1}, {1,0}, {-1,1}};
        int[][] shapeZ = piece.getShapeCoordinates();
        assertTrue(Arrays.deepEquals(shapeZ, testShapeZ));
    }

    @Test
    public  void createShapeJ(){
        shapeType = 4;
        piece = new Piece(shapeType);
        int[][] testShapeJ = {{0,0}, {0,1}, {0,2}, {-1,0}};
        int[][] shapeJ = piece.getShapeCoordinates();
        assertTrue(Arrays.deepEquals(shapeJ, testShapeJ));
    }

    @Test
    public  void createShapeT(){
        shapeType = 5;
        piece = new Piece(shapeType);
        int[][] testShapeT = {{0,0}, {0,1}, {1,1}, {-1,1}};
        int[][] shapeT = piece.getShapeCoordinates();
        assertTrue(Arrays.deepEquals(testShapeT, shapeT));
    }

    @Test
    public  void createShapeS(){
        shapeType = 6;
        piece = new Piece(shapeType);
        int[][] testShapeS = {{0,0}, {0,1}, {1,1}, {-1,0}};
        int[][] shapeS = piece.getShapeCoordinates();
        assertTrue(Arrays.deepEquals(testShapeS, shapeS));
    }

}
