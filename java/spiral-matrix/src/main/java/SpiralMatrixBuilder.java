import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class SpiralMatrixBuilder {

    private static enum POPULATE_NEXT_CELL {GO_RIGHT, GO_DOWN, GO_LEFT, GO_UP}

    ;

    public Integer[][] buildMatrixOfSize(int size) {
        Integer[][] matrix;
        matrix = new Integer[size][size];
        POPULATE_NEXT_CELL direction = POPULATE_NEXT_CELL.GO_RIGHT;
        Point cellCoordinate = new Point(0, 0);

        int counter = 1;
        while (counter <= (size * size)) {
            matrix[cellCoordinate.x][cellCoordinate.y] = counter++;

            switch (direction) {
                case GO_RIGHT: {
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        ++cellCoordinate.y;
                    } else {
                        ++cellCoordinate.x;
                        direction = POPULATE_NEXT_CELL.GO_DOWN;
                    }
                    break;
                }
                case GO_DOWN: {
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        ++cellCoordinate.x;
                    } else {
                        --cellCoordinate.y;
                        direction = POPULATE_NEXT_CELL.GO_LEFT;
                    }
                    break;
                }
                case GO_LEFT: {
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        --cellCoordinate.y;
                    } else {
                        --cellCoordinate.x;
                        direction = POPULATE_NEXT_CELL.GO_UP;
                    }
                    break;
                }
                case GO_UP:
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        --cellCoordinate.x;
                    } else {
                        ++cellCoordinate.y;
                        direction = POPULATE_NEXT_CELL.GO_RIGHT;
                    }
                    break;
            }
        }

        return matrix;
    }

    private boolean keepGoing(POPULATE_NEXT_CELL direction, Point cellCoordinate, Integer[][] matrix, int size) {
        int x = cellCoordinate.x;
        int y = cellCoordinate.y;

        if (direction == POPULATE_NEXT_CELL.GO_RIGHT) {
            return (((y + 1) <= size - 1) && matrix[x][y + 1] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_DOWN) {
            return (x + 1 <= size - 1 && matrix[x+1][y] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_LEFT) {
            return (y - 1 >= 0 && matrix[x][y - 1] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_UP) {
            return ((x - 1 >= 0) && (matrix[x - 1][y] == null));
        }

        return false;
    }
}
