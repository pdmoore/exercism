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
            int i = cellCoordinate.x;
            int j = cellCoordinate.y;

            switch (direction) {
                case GO_RIGHT: {
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        cellCoordinate = new Point(cellCoordinate.x, ++cellCoordinate.y);
                    } else {
                        cellCoordinate = new Point(++cellCoordinate.x, j);
                        direction = POPULATE_NEXT_CELL.GO_DOWN;
                    }
                    break;
                }
                case GO_DOWN: {
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        cellCoordinate = new Point(++cellCoordinate.x, j);
                    } else {
                        cellCoordinate = new Point(cellCoordinate.x, --j);
                        direction = POPULATE_NEXT_CELL.GO_LEFT;
                    }
                    break;
                }
                case GO_LEFT: {
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        cellCoordinate = new Point(cellCoordinate.x, --j);
                    } else {
                        cellCoordinate = new Point(--cellCoordinate.x, j);
                        direction = POPULATE_NEXT_CELL.GO_UP;
                    }
                    break;
                }
                case GO_UP:
                    if (keepGoing(direction, cellCoordinate, matrix, size)) {
                        cellCoordinate = new Point(--cellCoordinate.x, j);
                    } else {
                        cellCoordinate = new Point(cellCoordinate.x, ++j);
                        direction = POPULATE_NEXT_CELL.GO_RIGHT;
                    }
                    break;
            }
        }

        return matrix;
    }

    private boolean keepGoing(POPULATE_NEXT_CELL direction, Point cellCoordinate, Integer[][] matrix, int size) {
        int i = cellCoordinate.x;
        int j = cellCoordinate.y;

        if (direction == POPULATE_NEXT_CELL.GO_RIGHT) {
            return (((j + 1) <= size - 1) && matrix[i][j + 1] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_DOWN) {
            return (i + 1 <= size - 1 && matrix[i+1][j] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_LEFT) {
            return (j - 1 >= 0 && matrix[i][j - 1] == null);
        } else if (direction == POPULATE_NEXT_CELL.GO_UP) {
            return ((i - 1 >= 0) && (matrix[i - 1][j] == null));
        }

        return false;
    }
}
